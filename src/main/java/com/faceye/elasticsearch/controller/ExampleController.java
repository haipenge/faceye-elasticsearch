package com.faceye.elasticsearch.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleController {
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
}
