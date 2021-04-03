package org.springframework.samples.petclinic.junit5;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

	//@Test 	@Tag("fast")
	@DisplayName("JUNIT테스트 시작")
	@FastTest
	void create_new_study(){
		Study study = new Study();
		assertNotNull(study);
		assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디 처음 상태값 DRAFT 확인");

		//타임아웃 테스트(0.1초 안에 끝나는지 테스트)
		assertTimeout(Duration.ofMillis(100), () -> {
				new Study();
				Thread.sleep(30);
			});
		System.out.println("create" );
	}

	//@Test @Tag("slow")
	@DisplayName("JUNIT테스트 이름바꾸기")
	@SlowTest
	void create_new_study_again(){
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
