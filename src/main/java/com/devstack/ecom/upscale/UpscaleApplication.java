package com.devstack.ecom.upscale;

import com.devstack.ecom.upscale.service.UserRoleService;
import com.devstack.ecom.upscale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class UpscaleApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(UpscaleApplication.class, args);
	}

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;

	@Override
	public void run(String... args) throws Exception {
		userRoleService.initializerUserRoles();
		userService.initializeAdmin();
	}






}
