package com.granium.data.dto

import com.granium.data.Entity.Attachment
import com.granium.data.Entity.Category
import com.granium.data.Entity.Good
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.ManyToMany
import javax.validation.constraints.Size

/**
 * Created by Sasha.Chepurnoi on 27.08.16.
 */

class GoodInputDTO {
  var id: Int = 0
  @NotEmpty(message = "Title empty")
  var title: String = ""
  @NotEmpty(message = "Description empty")
  var description: String = ""
  @NotEmpty(message = "Select at least one category")
  var categories: MutableList<Category> = ArrayList()
  var attachments: List<AttachmentDTO> = ArrayList()
  @NotEmpty(message = "Add at least one file")
  var files: List<MultipartFile> = ArrayList()

  constructor()
}



class GoodUpdateDTO {
  var id: Int = 0
  @NotEmpty(message = "Title empty")
  var title: String = ""
  @NotEmpty(message = "Description empty")
  var description: String = ""
  @NotEmpty(message = "Select at least one category")
  var categories: MutableList<Category> = ArrayList()
  var attachments: List<AttachmentDTO> = ArrayList()
  var files: List<MultipartFile> = ArrayList()

  constructor()
}
class GoodResponse {
  var id: Int = 0
  var title: String = ""
  var description: String = ""
  var categories: MutableList<Category> = ArrayList()
  var attachments: List<Attachment> = ArrayList()
  var files: List<MultipartFile> = ArrayList()

  constructor()
  constructor(good: Good){
    this.id = good.id
    this.title = good.title
    this.description = good.description
    this.categories = good.categories
    this.attachments = good.attachments
  }
}


class AttachmentDTO {
  var id: Int = 0
  var url: String = ""
  var type: String = "image"
}

