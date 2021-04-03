package org.springframework.samples.petclinic.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

	@Test
	@DisplayName("JUNIT테스트 시작")
	void create(){
		Study study = new Study();
		assertNotNull(study);
		System.out.println("create" );
	}

	@Test
	@DisplayName("JUNIT테스트 이름바꾸기")
	void create1(){
		System.out.println("StudyTest.create1");
	}

	@BeforeAll
	static void beforeAll(){
		System.out.println("StudyTest.beforeAll");
	}

	@AfterAll
	static void afterAll(){
		System.out.println("StudyTest.afterAll");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("StudyTest.beforeEach");
	}

	@AfterEach
	void afterEach(){
		System.out.println("StudyTest.afterEach");
	}
}
