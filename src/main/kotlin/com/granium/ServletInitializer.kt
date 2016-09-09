package com.granium

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {
	override fun configure(application: SpringApplicationBuilder) : SpringApplicationBuilder {
		return application.sources(WebappApplication::class.java)
	}

}
