package com.granium.controller.admin

import com.granium.Services.GoodsService
import com.granium.data.Entity.Category
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */

@Controller
@RequestMapping("/admin")
class AdminController constructor() {

  val logger = LoggerFactory.getLogger(javaClass)
  val ADMIN_BOARD = "admin/board"

  @Autowired lateinit var goodsService: GoodsService

  @RequestMapping(path = arrayOf("", "/"), method = arrayOf(RequestMethod.GET))
  fun adminboard() = ADMIN_BOARD

  @ModelAttribute(value = "boardInfo") fun getBoardInfo() = goodsService.categoriesCount() to goodsService.goodsCount()

}