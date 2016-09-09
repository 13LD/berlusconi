package com.granium.data.Entity

import com.granium.data.dto.*
import java.math.BigInteger
import java.util.*
import javax.persistence.*

/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */


@Entity
@Table(name = "category")
class Category {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Int = 0

  @ManyToMany(mappedBy = "categories",cascade = arrayOf(CascadeType.ALL))
  lateinit var goods: MutableList<Good>

  @Column(name = "name")
  var name: String = ""

  @Column(name = "description")
  var description: String = ""

  @Column(name = "image")
  var image: String = ""


  constructor()
  constructor(dto: CategoryCreateDTO) {
    this.id = dto.id
    name = dto.name
    description = dto.description
  }

  constructor(dto: CategoryUpdateDTO) {
    this.id = dto.id
    name = dto.name
    description = dto.description
  }
}

@Entity
@Table(name = "good")
class Good {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Int = 0
  @Column(name = "title")
  var title: String = ""
  @Column(name = "description")
  var description: String = ""

  @ManyToMany(cascade = arrayOf(CascadeType.PERSIST))
  @JoinTable(name = "category_to_good",
      joinColumns = arrayOf(JoinColumn(name = "good_id")),
      inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
  lateinit var categories: MutableList<Category>

  @OneToMany(mappedBy = "good")
  lateinit var attachments: MutableList<Attachment>

  constructor()

  constructor(goodDTO: GoodInputDTO) {
    id = goodDTO.id
    title = goodDTO.title
    description = goodDTO.description
    categories = goodDTO.categories
    attachments = ArrayList()
  }

  constructor(goodDTO: GoodUpdateDTO) {
    id = goodDTO.id
    title = goodDTO.title
    description = goodDTO.description
    categories = goodDTO.categories
    attachments = ArrayList()
  }
}


@Entity
@Table(name = "attachment")
class Attachment {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Int = 0
  @ManyToOne
  @JoinColumn(name = "good_id")
  lateinit var good: Good
  @Column(name = "url")
  var url: String = ""
  @Column(name = "type")
  var type: String = "image"


  constructor(attach: AttachmentDTO) {
    this.id = attach.id
    this.url = attach.url
    this.type = attach.type
  }

  constructor()

  override fun toString(): String{
    return "Attachment(id=$id, good=$good, url='$url', type='$type')"
  }



}