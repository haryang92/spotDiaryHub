CREATE TABLE `file` (
        `id` int NOT NULL AUTO_INCREMENT,
        `spot_id` int NOT NULL COMMENT '장소id',
        `user_id` int NOT NULL COMMENT '유저id',
        `original_name` varchar(260) NOT NULL COMMENT '원본파일명',
        `save_name` varchar(40) NOT NULL COMMENT '서버저장파일명',
        `size` int NOT NULL COMMENT '파일크기',
        `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
        `deleted_at` datetime DEFAULT NULL COMMENT '삭제일자',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='파일';