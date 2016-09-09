package com.granium.controller.admin

import com.granium.Services.GoodsService
import com.granium.data.Entity.Category
import com.granium.data.dto.GoodInputDTO
import com.granium.data.dto.GoodResponse
import com.granium.data.dto.GoodUpdateDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

/**
 * Created by Sasha.Chepurnoi on 24.08.16.
 */

@Controller
@RequestMapping("/admin/good")
class GoodController {


  val logger = LoggerFactory.getLogger(javaClass)
  val CREATE_GOOD_FORM = "admin/create_good"
  val LIST_GOODS = "admin/list_goods"


  @Autowired lateinit var goodsService: GoodsService
  @RequestMapping(path = arrayOf("create", "create/"), method = arrayOf(RequestMethod.GET))
  fun getCreateGoodForm(modelMap: ModelMap) = modelMap
      .apply { addAttribute("goodsList", goodsService.getGoods()) }
//      .apply { addAttribute("categoriesList", goodsService.getCategoriest()) }
      .let { CREATE_GOOD_FORM }

  @RequestMapping(path = arrayOf("", "/"), method = arrayOf(RequestMethod.GET))
  fun getGoodsList(modelMap: ModelMap) = modelMap
      .apply { addAttribute("goodsList", goodsService.getGoods()) }
      .let { LIST_GOODS }

  @RequestMapping(path = arrayOf("{id}", "{id}/"), method = arrayOf(RequestMethod.GET))
  fun getGoodPage(@PathVariable(value = "id") id: Int, modelMap: ModelMap) = modelMap
      .apply { addAttribute("GoodDTO", GoodResponse(goodsService.getGood(id))) }
//      .apply { addAttribute("categoriesList", goodsService.getCategoriest()) }
      .let { CREATE_GOOD_FORM }

  @ModelAttribute(value = "GoodDTO") fun getGoodInputDTO() = GoodInputDTO()
  @ModelAttribute(value = "categoriesList") fun getCategoryList() = goodsService.getCategoriest()


  @RequestMapping(path = arrayOf("create", "create/"), method = arrayOf(RequestMethod.POST))
  fun saveGood(@Valid @ModelAttribute("GoodInputDTO") goodDTO: GoodInputDTO,
               result: BindingResult): String {
    if(result.hasErrors()) return CREATE_GOOD_FORM
    goodsService.save(goodDTO)
    return "redirect:/admin"
  }

  @RequestMapping(path = arrayOf("{id}", "{id}/"), method = arrayOf(RequestMethod.POST))
  fun updateGood(@PathVariable(value = "id") id: Int,
                 @Valid @ModelAttribute("GoodUpdateDTO") good: GoodUpdateDTO,
                 result: BindingResult): String {
    if(result.hasErrors()) return CREATE_GOOD_FORM
    goodsService.update(good)
    return "redirect:/admin/good"
  }

  @RequestMapping(path = arrayOf("{id}/delete", "{id}/delete/"), method = arrayOf(RequestMethod.POST))
  fun deleteGood(@PathVariable(value = "id") id: Int): String {
    goodsService.deleteGood(id)
    return "redirect:/admin/good"
  }


}
