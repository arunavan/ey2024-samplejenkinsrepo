package com.adp.batch3sampleprojectrepo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adp.batch3sampleprojectrepo.controller.ProductController;

@SpringBootTest
class Batch3SampleprojectRepoApplicationTests {

	@Autowired
	ProductController productController;
	@Test
	public void testGetProduct() {
		
		assertEquals("PRoductDEtails",productController.getProduct());
	}
	
	@Test
	public void  testGetMsg() {
		
		assertEquals("welcome",productController.getMsg("welcome"));
	}
	

}
