package com.sein.service;

import com.sein.pojo.dto.PageResult;
import com.sein.pojo.po.Equation;
import com.sein.utils.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquationServiceTest {

	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EquationService equationService;

	@Test
	public void testListEquation() {
		PageResult<Equation> klmb = equationService.listEquation(1, 10, "klmb");
		String s = JacksonUtil.toJSon(klmb);
		logger.info(s);
	}

}
