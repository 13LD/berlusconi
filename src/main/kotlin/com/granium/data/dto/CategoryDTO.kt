package com.granium.data.dto

import com.granium.data.Entity.Category
import com.granium.data.Entity.Good
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.web.multipart.MultipartFile
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by Sasha.Chepurnoi on 07.09.16.
 */


class CategoryCreateDTO{
  var id: Int = 0
  @NotEmpty(message = "Name empty")
  var name: String = ""
  @NotEmpty(message = "Description empty")
  var description: String = ""
  var imageUrl: String = ""
  @NotNull(message = "Image empty")
  lateinit var imagefile: MultipartFile

  constructor(cat: Category){
    id = cat.id
    name = cat.name
    description = cat.description
    imageUrl = cat.image
  }

  constructor()
}

class CategoryUpdateDTO{
  var id: Int = 0
  @NotEmpty(message = "Name empty")
  var name: String = ""
  @NotEmpty(message = "Description empty")
  var description: String = ""
  var imageUrl: String = ""
  lateinit var imagefile: MultipartFile

  constructor(cat: Category){
    id = cat.id
    name = cat.name
    description = cat.description
    imageUrl = cat.image
  }

  constructor()
}
