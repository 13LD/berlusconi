package com.granium.controller.admin

import com.granium.Services.GoodsService
import com.granium.data.dto.CategoryCreateDTO
import com.granium.data.dto.CategoryUpdateDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.validation.Valid

/**
 * Created by Sasha.Chepurnoi on 03.09.16.
 */


@Controller
@RequestMapping("/admin/category")
class CategoryController {

  val logger = LoggerFactory.getLogger(javaClass)
  val CREATE_CATEGORY_FORM = "admin/create_category"
  val LIST_CATEGORIES = "admin/list_categories"


  @Autowired lateinit var goodsService: GoodsService

  @RequestMapping(path = arrayOf("create", "create/"), method = arrayOf(RequestMethod.GET))
  fun getCreateCategoryForm() = CREATE_CATEGORY_FORM

  @RequestMapping(path = arrayOf("", "/"), method = arrayOf(RequestMethod.GET))
  fun getCategoriesList(modelMap: ModelMap) = modelMap
      .apply { addAttribute("categoriesList", goodsService.getCategoriest()) }
      .let { LIST_CATEGORIES }

  @RequestMapping(path = arrayOf("{id}", "{id}/"), method = arrayOf(RequestMethod.GET))
  fun getCategoryPage(@PathVariable(value = "id") id: Int, modelMap: ModelMap) = modelMap
      .apply { addAttribute("Category", CategoryUpdateDTO(goodsService.getCategory(id))) }
      .let { CREATE_CATEGORY_FORM }

  @ModelAttribute(value = "Category") fun getCategory() = CategoryCreateDTO()

  @RequestMapping(path = arrayOf("create", "create/"), method = arrayOf(RequestMethod.POST))
  fun saveCategory(@Valid @ModelAttribute("Category") category: CategoryCreateDTO,
                   modelMap: ModelMap,
                   result: BindingResult): String {
    if (result.hasErrors()) return CREATE_CATEGORY_FORM
    goodsService.save(category)
    return "redirect:/admin"
  }

  @RequestMapping(path = arrayOf("{id}", "{id}/"), method = arrayOf(RequestMethod.POST))
  fun updateCategory(@PathVariable(value = "id") id: Int,
                     @Valid @ModelAttribute("Category") category: CategoryUpdateDTO,
                     modelMap: ModelMap,
                     result: BindingResult): String {
    if (result.hasErrors()) return CREATE_CATEGORY_FORM
    goodsService.update(category)
    return "redirect:/admin/category"
  }

  @RequestMapping(path = arrayOf("{id}/delete", "{id}/delete/"), method = arrayOf(RequestMethod.POST))
  fun deleteCategory(@PathVariable(value = "id") id: Int): String {
    goodsService.deleteCategory(id)
    return "redirect:/admin/category"
  }


}