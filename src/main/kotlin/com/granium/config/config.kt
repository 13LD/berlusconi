package com.granium.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.multipart.commons.CommonsMultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver
import javax.servlet.MultipartConfigElement
import javax.servlet.ServletContext

/**
 * Created by Sasha.Chepurnoi on 22.07.16.
 */

@Configuration
@EnableWebMvc
open class MvcConfiguration : WebMvcConfigurerAdapter() {

  @Bean
  open fun viewResolver(): ViewResolver {
    val resolver = InternalResourceViewResolver()
    resolver.setPrefix("/WEB-INF/webpages/")
    resolver.setSuffix(".jsp")
    return resolver
  }

  @Bean
  open fun multipartResolver() = StandardServletMultipartResolver()

  @Bean
  open fun multipartConfigElement(): MultipartConfigElement {
    val factory = MultipartConfigFactory()
    factory.setMaxFileSize("5120MB")
    factory.setMaxRequestSize("5120MB")
    return factory.createMultipartConfig()
  }

  override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer?) {
    configurer!!.enable()
  }

  override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
    super.addResourceHandlers(registry)
    registry?.addResourceHandler("/resources/**")?.addResourceLocations("/resources/")
  }
}

@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http
        .authorizeRequests()
        .antMatchers("/admin", "/admin/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .permitAll();
  }

  @Autowired
  @Throws(Exception::class)
  fun configureGlobal(auth: AuthenticationManagerBuilder) {
    auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
  }

}