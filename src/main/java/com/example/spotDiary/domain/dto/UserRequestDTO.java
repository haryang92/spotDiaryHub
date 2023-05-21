package com.example.spotDiary.domain.dto;

import com.example.spotDiary.domain.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // (access = AccessLevel.PROTECTED)
public class UserRequestDTO {

		private String userId;  // 사용자id
		private String pw;      // 패스워드
		private String name;    // 이름
		private String email;   // 이메일

		@Builder
		public UserRequestDTO(String userId, String pw, String name, String email) {
				this.userId = userId;
				this.pw = pw;
				this.name = name;
				this.email = email;
		}

		// DTO -> Entity
		public User toEntity() {
				return User.builder()
								.userId(userId)
								.pw(pw)
								.name(name)
								.email(email)
								.build();
		}

}
