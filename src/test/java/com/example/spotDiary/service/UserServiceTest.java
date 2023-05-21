package com.example.spotDiary.service;

import com.example.spotDiary.domain.dto.UserRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceTest {

		@Autowired
		UserService userService;

//		@BeforeEach
//		public void beforeEach() {
//				interface repository를 beforeEach에 쓸 수 있는 방법 ?
//				memberRepository = new MemberRepository();
//		}

		@Test
		void 회원가입() {
				// Given 회원데이터 set
				UserRequestDTO userRequestDTO = new UserRequestDTO();
				userRequestDTO.setUserId("ccc");
				userRequestDTO.setPw("1111");
				userRequestDTO.setName("하량");
				userRequestDTO.setEmail("abc@naver.com");

				// When 실행했을 때
				userService.join(userRequestDTO);

				// Then saveId 확인한다.
		}

		@Test
		void 로그인() {
				// given 회원데이터 set
				UserRequestDTO requestDTO = new UserRequestDTO();
				requestDTO.setUserId("ccc");
				requestDTO.setPw("1111");

				// when 실행했을 때
				userService.login(requestDTO);

		}






}