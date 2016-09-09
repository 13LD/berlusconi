package com.granium.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */

@Controller
class LoginController() {

    val LOGIN_PAGE = "login"

    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.GET))
    fun login() = LOGIN_PAGE

}