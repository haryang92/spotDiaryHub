package com.example.spotDiary.domain.dto;

import com.example.spotDiary.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserResponseDTO implements Serializable {

		private Long id;                                         // 고유id
		private String userId;                                   // 사용자id
		private String pw;                                       // 패스워드
		private String name;                                     // 이름
		private String email;                                    // 이메일
		private LocalDateTime createdAt = LocalDateTime.now();   // 가입일
		private LocalDateTime deletedAt;

		// Entity -> DTO
		public UserResponseDTO(User user) {
				this.id = user.getId();
				this.userId = user.getUserId();
				this.pw = user.getPw();
				this.name = user.getName();
				this.email = user.getEmail();
		}
}
