package com.example.spotDiary.service;

import com.example.spotDiary.domain.dto.UserRequestDTO;
import com.example.spotDiary.domain.dto.UserSessionDTO;
import com.example.spotDiary.domain.entity.User;
import com.example.spotDiary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

		private final UserRepository userRepository;

		private final BCryptPasswordEncoder encoder;

		@Autowired
		public UserService(UserRepository userRepository, HttpSession session, BCryptPasswordEncoder encoder) {
				this.userRepository = userRepository;
				this.encoder = encoder;
		}

		/**
		 * 회원 가입
		 */
		@Transactional
		public Long join(UserRequestDTO requestDTO) {

				validateDuplicateMember(requestDTO); // 중복 회원 체크
				requestDTO.setPw(encoder.encode(requestDTO.getPw()));
				User user = userRepository.save(requestDTO.toEntity());
				return user.getId();

		}

		/**
		 * 중복 회원 가입 체크
		 */
		private void validateDuplicateMember(UserRequestDTO requestDTO) {

				// 같은 id 있는 경우 회원x
				Optional<User> result = userRepository.findByUserId(requestDTO.getUserId());
				result.ifPresent(user -> {
						throw new IllegalStateException("이미 존재하는 아이디가 있습니다.");
				});

		}

		/**
		 * 로그인
		 */
		public User login(UserRequestDTO userRequestDTO) {
				Optional<User> findMember = userRepository.findByUserId(userRequestDTO.getUserId());
//				if(!findMember.isPresent() || ){
//						throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
//				}
				return findMember.get();
		}



}
