CREATE TABLE `diary` (
        `id` bigint NOT NULL AUTO_INCREMENT,
        `user_id` int NOT NULL COMMENT '유저id',
        `content` varchar(1000) NOT NULL COMMENT '내용',
        `emoji` varchar(10) NOT NULL COMMENT '이모지',
        `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입일자',
        `updated_at` datetime DEFAULT NULL COMMENT '수정일자',
        `deleted_at` datetime DEFAULT NULL COMMENT '탈퇴일자',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='다이어리';
