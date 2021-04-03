package org.springframework.samples.petclinic.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {
	int value = 1;

	//@Test 	@Tag("fast")
	@Order(2)
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
		System.out.println("create   value:" + value++ );
	}

	//@Test @Tag("slow")
	@Order(1)
	@DisplayName("JUNIT테스트 이름바꾸기")
	@SlowTest
	void create_new_study_again(){
		System.out.println("StudyTest.create1  value:"+value++);
	}

	@Order(4)
	@DisplayName("반복테스트 10회")
	@RepeatedTest(10)
	void repeatTest(RepetitionInfo repetitionInfo){
		System.out.println("StudyTest.repeatTest" + repetitionInfo.getCurrentRepetition());
	}

	@Order(3)
	@DisplayName("반복테스트 밸류입력")
	@ParameterizedTest
	@ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
	@NullAndEmptySource
	void parameterTest(String message){
		System.out.println("StudyTest.parameteriTest:" + message +"   value:"+ value++);
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
