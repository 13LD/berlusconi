package com.granium.Services

import com.granium.data.Entity.Attachment
import com.granium.data.Entity.Category
import com.granium.data.Entity.Good
import com.granium.data.Repos.AttachmentsRepo
import com.granium.data.Repos.CategoriesRepo
import com.granium.data.Repos.GoodsRepo
import com.granium.data.dto.*
import javassist.NotFoundException
import org.omg.CosNaming.NamingContextPackage.NotFound
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * Created by Sasha.Chepurnoi on 23.08.16.
 */

@Service
@Transactional
open class GoodsServiceImpl @Autowired constructor(
    val goodsRepo: GoodsRepo,
    val categoriesRepo: CategoriesRepo,
    val attachmentsRepo: AttachmentsRepo,
    val amazonS3Service: AmazonS3Service
) : GoodsService {


  override fun getGood(id: Int): Good = goodsRepo.findOne(id) ?: throw NotFoundException("Not found")

  override fun getCategory(id: Int): Category = categoriesRepo.findOne(id) ?: throw NotFoundException("Not found")

  override fun getGoodByCategory(cat: Category): MutableList<Good> {
    return goodsRepo.getByCategoriesContains(cat)
  }

  override fun getGoods() = goodsRepo.findAll()

  override fun save(goodDTO: GoodInputDTO) {

    val new = goodsRepo.save(Good(goodDTO))
    val attachments = goodDTO.files.map {
      Attachment()
          .apply { url = amazonS3Service.saveAttachmentImage(it.originalFilename, it.inputStream) }
          .apply { good = new }
    }
    attachmentsRepo.save(attachments)
  }

  override fun update(goodDTO: GoodUpdateDTO) {

    val obsolete = goodsRepo.getOne(goodDTO.id) ?: throw InternalError("Cant find this entity in database")
    val removed = obsolete.attachments.filter { goodDTO.attachments.none { l -> it.id == l.id } }

    removed.forEach { amazonS3Service.deleteImage(it.url) }
    attachmentsRepo.delete(removed)

    val updated = goodsRepo.save(Good(goodDTO))
    val attachments = goodDTO.files.map {
      Attachment()
          .apply { url = amazonS3Service.saveAttachmentImage(it.originalFilename, it.inputStream) }
          .apply { good = updated }
    }
    attachmentsRepo.save(attachments)
  }

  override fun deleteGood(id: Int): String {
    val good = getGood(id)
    attachmentsRepo.delete(good.attachments)
    goodsRepo.delete(good)
    return "Good $id deleted"
  }

  override fun deleteCategory(id: Int): String {
    val category = categoriesRepo.findOne(id) ?: throw NotFoundException("Not found")
    if (category.goods.size > 0) return "Category has goods"
    categoriesRepo.delete(id)
    return "Deleted $id category"
  }

  override fun save(category: CategoryCreateDTO) {
    val new = Category(category)
    if (!category.imagefile.originalFilename.isEmpty())
      new.image = amazonS3Service.saveCategoryImage(category.imagefile.originalFilename, category.imagefile.inputStream)
    categoriesRepo.save(new)
  }

  override fun update(category: CategoryUpdateDTO) {
    val old = categoriesRepo.getOne(category.id) ?: throw NotFoundException("Not found")
    old.name = category.name
    old.description = category.description
    if (!category.imagefile.originalFilename.isEmpty()) {
      amazonS3Service.deleteImage(old.image)
      old.image = amazonS3Service.saveCategoryImage(category.imagefile.originalFilename, category.imagefile.inputStream)
    }
    categoriesRepo.save(old)
  }

  override fun getCategoriest(): MutableList<Category> = categoriesRepo.findAll()


  override fun categoriesCount(): Long = categoriesRepo.count()


  override fun goodsCount(): Long = goodsRepo.count()
}