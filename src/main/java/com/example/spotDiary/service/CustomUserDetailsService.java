package com.example.spotDiary.service;

import com.example.spotDiary.domain.dto.UserSessionDTO;
import com.example.spotDiary.domain.entity.User;
import com.example.spotDiary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

		private final UserRepository userRepository;

		private final HttpSession httpSession;

		/* userID가 DB에 있는지 확인 */
		@Override
		public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
				User user = userRepository.findByUserId(userId).orElseThrow(()->
								new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + userId));

				httpSession.setAttribute("user", new UserSessionDTO(user));

				// 시큐리티 세션에 유저 정보 저장
				return new CustomUserDetails(user);
		}
}
