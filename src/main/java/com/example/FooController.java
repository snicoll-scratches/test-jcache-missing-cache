package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	private final FooService fooService;

	public FooController(FooService fooService) {
		this.fooService = fooService;
	}

	@RequestMapping("/foos/{foo}")
	public String getFoo(@PathVariable String foo) {
		return this.fooService.getFoo(foo);
	}

	@RequestMapping("/bars/{bar}")
	public String getBar(@PathVariable String bar) {
		return this.fooService.getBar(bar);
	}

}
