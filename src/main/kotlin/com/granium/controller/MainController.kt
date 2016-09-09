package com.granium.controller

import com.granium.Services.GoodsService
import com.granium.main
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */

@Controller
class MainController() {

  @Autowired
  lateinit var goodsService: GoodsService

  val MAIN = "main"
  val CATEGORIES = "categories"
  val ITEMS_PAGE = "items"


  @RequestMapping(value = "", method = arrayOf(RequestMethod.GET))
  fun entryPoint() = MAIN

  @RequestMapping(path = arrayOf("categories/", "categories"), method = arrayOf(RequestMethod.GET))
  fun categories(modelMap: ModelMap) = modelMap
      .apply { modelMap.addAttribute("categories", goodsService.getCategoriest()) }
      .let { CATEGORIES }

  @RequestMapping(path = arrayOf(
      "categories/{categoryId}",
      "categories/{categoryId}/"))
  fun loadItems(@PathVariable categoryId: Int,
                modelMap: ModelMap) = modelMap
      .apply { modelMap.addAttribute("goods", goodsService.getGoodByCategory(goodsService.getCategory(categoryId))) }
      .let { ITEMS_PAGE }

  @RequestMapping(value = "test", method = arrayOf(RequestMethod.GET))
  fun test() = "item_page"

  @RequestMapping(value = "test", method = arrayOf(RequestMethod.POST))
  fun postTest(@RequestParam("attachments") file: MultipartFile?): String {
    val logger = LoggerFactory.getLogger("File logger")
    logger.info(file?.originalFilename)
    return "testpage"
  }


}


