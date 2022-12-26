package com.mahov.superkassa.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.yaml")
class TestTaskForJuniorJavaDevPositionApplicationTests {

	@Test
	void contextLoads() {
	}

}
