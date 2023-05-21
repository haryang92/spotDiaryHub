CREATE TABLE `spot` (
        `id` bigint NOT NULL AUTO_INCREMENT,
        `user_id` int NOT NULL COMMENT '유저id',
        `diary_id` int NOT NULL COMMENT '다이어리id',
        `name` varchar(100) NOT NULL COMMENT '장소명',
        `place_id` int NOT NULL COMMENT '카카오장소id',
        `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
        `deleted_at` datetime DEFAULT NULL COMMENT '삭제일자',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='장소';