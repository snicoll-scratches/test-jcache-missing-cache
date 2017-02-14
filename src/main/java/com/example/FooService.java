package com.example;

import java.time.Instant;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FooService {

	@Cacheable("foo")
	public String getFoo(String foo) {
		return Instant.now() + " - " + foo;
	}

	@Cacheable("bar")
	public String getBar(String bar) {
		return Instant.now() + " - " + bar;
	}

}
