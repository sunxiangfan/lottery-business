CREATE TABLE `user_info` (
  `user_id` varchar(32) NOT NULL COMMENT 'UUID',
  `login_name` varchar(32) NOT NULL,
  `login_pswd` varchar(64) NOT NULL,
  `p_user_id` varchar(32) NOT NULL,
  `is_lock` varchar(1) NOT NULL COMMENT 'Y被锁  N未锁',
  `lock_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `login_name_pswd_key` (`login_name`,`login_pswd`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;