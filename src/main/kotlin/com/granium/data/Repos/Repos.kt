package com.granium.data.Repos

import com.granium.data.Entity.Attachment
import com.granium.data.Entity.Category
import com.granium.data.Entity.Good
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.math.BigInteger

/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */

interface AttachmentsRepo : JpaRepository<Attachment, Int> {

}

interface GoodsRepo : JpaRepository<Good, Int> {
  fun getByCategoriesContains(cat: Category): MutableList<Good>
}

interface CategoriesRepo : JpaRepository<Category, Int> {

}


