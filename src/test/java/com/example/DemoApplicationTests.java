package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class DemoApplicationTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private FooService fooService;

	@Test
	public void fooCacheExists() {
		String result = this.fooService.getFoo("test");
		assertThat(result).contains("test");
		assertThat(this.fooService.getFoo("test")).isEqualTo(result);
	}

	@Test
	public void barCacheDoesNotExist() {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("Cannot find cache named 'bar'");
		this.thrown.expectMessage(FooService.class.getName());
		this.thrown.expectMessage("getBar");
		this.fooService.getBar("test");
	}

}
