CREATE TABLE `user_info` (
  `user_id` varchar(32) NOT NULL COMMENT 'UUID',
  `login_name` varchar(32) NOT NULL,
  `login_pswd` varchar(64) NOT NULL,
  `p_user_id` varchar(32),
  `is_lock` varchar(1) NOT NULL COMMENT 'Y被锁  N未锁',
  `lock_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `login_name_pswd_key` (`login_name`,`login_pswd`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table bank_card (
  id 						varchar(32) not null comment 'ID',
  user_id				varchar(32) not null comment '用户ID',
  card_num 			varchar(32) not null comment '卡号',
  card_holder 	varchar(16) not null comment '持卡人',
  primary key (id)
)comment '银行卡信息';

create table lottery_num (
  id 						    varchar(32) not null comment 'ID',
  lottery_code			varchar(8) not null comment '彩种',
  lottery_num 			varchar(32) not null comment '开奖号码',
  lottery_periods varchar(16) not null comment '开奖期数',
  time 	  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '开奖时间',
  primary key (id)
)comment '开奖信息';

create table lottery_record (
  id 						    varchar(32) not null comment '购彩记录ID',
  user_id			    varchar(32) not null comment '用户ID',
  lottery_code			varchar(8) not null comment '彩种',
  purchase_num 			varchar(16) not null comment '购彩号码',
  lottery_periods varchar(16) not null comment '购彩期数',
  multiple integer (8) not null comment '倍数',
  lottery_amount DECIMAL(11,2) not null comment '购彩金额',
  status			varchar(8) not null comment '购彩状态',
  prize_status			varchar(8) not null comment '中奖状态',
  time 	  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '购买时间',
  primary key (id)
)comment '购彩记录';