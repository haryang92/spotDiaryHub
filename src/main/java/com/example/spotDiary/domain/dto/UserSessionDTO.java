package com.example.spotDiary.domain.dto;

import com.example.spotDiary.domain.entity.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 인증된 사용자 정보를 세션에 저장하기 위한 클래스
 */
@Getter
public class UserSessionDTO implements Serializable {

		private String userId;  // 사용자id
		private String pw;      // 패스워드
		private String name;    // 이름
		private String email;   // 이메일

//		Entity -> DTO
		public UserSessionDTO(User user) {
				this.userId = user.getUserId();
				this.pw = user.getPw();
				this.name = user.getName();
				this.email = user.getEmail();
		}

		/*
		User 엔티티 클래스에 직접 세션을 저장하려면 직렬화를 해야 하는데,
		엔티티 클래스에 직렬화를 해준다면 추후에 다른 엔티티와 연관관계를 맺을 시 직렬화 대상에 다른 엔티티까지 포함될 수 있어
		성능 이슈, 부수 효과 우려가 있다. -스프링 부트와 AWS로 혼자 구현하는 웹 서비스 中-
		 */
}
