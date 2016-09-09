package com.granium.Services

import com.granium.data.Entity.Category
import com.granium.data.Entity.Good
import com.granium.data.dto.*

import java.io.InputStream


/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */


//@TODO separate into 2 services
interface GoodsService{
  fun getCategoriest(): MutableList<Category>
  fun categoriesCount(): Long
  fun goodsCount(): Long

  fun save(goodDTO: GoodInputDTO)

  fun getGoods(): MutableList<Good>

  fun getCategory(id: Int): Category

  fun getGood(id: Int): Good

  fun deleteGood(id: Int) : String

  fun deleteCategory(id: Int) : String
  fun update(goodDTO: GoodUpdateDTO)

  fun save(category: CategoryCreateDTO)

  fun update(goodDTO: CategoryUpdateDTO)
  open fun getGoodByCategory(cat: Category): MutableList<Good>
}


interface AmazonS3Service {

  fun saveAttachmentImage(filename: String, stream: InputStream): String
  fun saveCategoryImage(filename: String, stream: InputStream): String

  fun deleteImage(url: String)

}