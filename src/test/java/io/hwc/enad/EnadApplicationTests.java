package io.hwc.enad;





import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.hwc.enad.controller.HelloController;

@SpringBootTest
class EnadApplicationTests {

	@Autowired
	private HelloController helloController;

	@Test
	public void contextLoads() {
		
		Assert.assertEquals("Hello World from ENAD",helloController.home() );
	}

}
