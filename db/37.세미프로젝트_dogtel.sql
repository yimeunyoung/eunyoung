DROP DATABASE IF exists dogtel;
CREATE DATABASE dogtel;
USE dogtel;
CREATE TABLE `member` (
	`me_id`	varchar(10)   PRIMARY KEY	NOT NULL,
	`me_le_name`	varchar(10)	NOT NULL	DEFAULT '일반',
	`me_pw`	varchar(255)	NOT NULL,
	`me_name`	varchar(20)	NOT NULL,
	`me_address`	varchar(100)	NOT NULL,
	`me_phone`	char(13)	NOT NULL,
	`me_total_price`	int	NOT NULL	DEFAULT 0,
	`me_authority`	varchar(5)	NOT NULL  DEFAULT 'USER',
	`me_point`	int	NOT NULL	DEFAULT 0
);

CREATE TABLE `branch` (
	`br_num`	int AUTO_INCREMENT  PRIMARY KEY	NOT NULL,
	`br_name`	varchar(10)	NOT NULL,
	`br_phone`	char(13)	NOT NULL
);

CREATE TABLE `dog` (
	`d_num`	varchar(13)   PRIMARY KEY	NOT NULL,
	`d_name`	varchar(20)	NOT NULL,
	`d_age`	int	NOT NULL,
	`d_age_type`	char(1)	NOT NULL,
	`d_gen`	char(1)	NULL,
	`d_kg`	int	NOT NULL,
	`d_detail`	varchar(50)	NULL,
	`d_me_id`	varchar(10)	NOT NULL,
	`d_si_name`	varchar(6)	NOT NULL
);

CREATE TABLE `room` (
	`ro_num`	int AUTO_INCREMENT  PRIMARY KEY	NOT NULL,
	`ro_name`	varchar(10)	NOT NULL,
	`ro_max_cap`	int	NOT NULL,
	`ro_now_cap`	int	NOT NULL	DEFAULT 0,
	`ro_detail`	varchar(50)	NULL,
	`ro_br_num`	int	NOT NULL
);

CREATE TABLE `price` (
	`si_pr_name`	varchar(6)   PRIMARY KEY	NOT NULL,
	`pr_price`	int	NOT NULL	DEFAULT 0
);

CREATE TABLE `reservationList` (
	`rl_num`	int  AUTO_INCREMENT  PRIMARY KEY	NOT NULL,
	`rl_d_num`	varchar(13)	NOT NULL,
	`rl_ro_num`	int	NOT NULL,
	`rl_re_num`	int	NOT NULL
);

CREATE TABLE `point` (
	`po_num`	int AUTO_INCREMENT  PRIMARY KEY	NOT NULL,
	`po_point`	int	NOT NULL	DEFAULT 0,
	`po_content`	varchar(30)	NULL,
	`po_me_id`	varchar(10)	NOT NULL
);

CREATE TABLE `level` (
	`le_name`	varchar(10)   PRIMARY KEY	NOT NULL	DEFAULT '일반',
	`le_benefit`	int	NOT NULL	DEFAULT 5
);

CREATE TABLE `reservation` (
	`re_num`	int   PRIMARY KEY	NOT NULL,
	`re_me_id`	varchar(10)	NOT NULL,
	`re_date`	date	NOT NULL,
	`re_stay`	int	NOT NULL	DEFAULT 1,
	`re_s_count`	int	NOT NULL	DEFAULT 0,
	`re_m_count`	int	NOT NULL	DEFAULT 0,
	`re_l_count`	int	NOT NULL	DEFAULT 0,
	`re_state`	varchar(5)	NOT NULL	DEFAULT '완료',
	`re__price`	int	NOT NULL	DEFAULT 0,
	`re_real_price`	int	NOT NULL	DEFAULT 0,
	`re_use_point`	int	NOT NULL	DEFAULT 0,
	`re_add_point`	int	NOT NULL	DEFAULT 0
);

CREATE TABLE `size` (
	`si_name`	varchar(6)   PRIMARY KEY	NOT NULL,
	`si_min_kg`	int	NOT NULL	DEFAULT 0
);


ALTER TABLE `member` ADD CONSTRAINT `FK_level_TO_member_1` FOREIGN KEY (
	`me_le_name`
)
REFERENCES `level` (
	`le_name`
);

ALTER TABLE `dog` ADD CONSTRAINT `FK_member_TO_dog_1` FOREIGN KEY (
	`d_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `dog` ADD CONSTRAINT `FK_size_TO_dog_1` FOREIGN KEY (
	`d_si_name`
)
REFERENCES `size` (
	`si_name`
);

ALTER TABLE `room` ADD CONSTRAINT `FK_branch_TO_room_1` FOREIGN KEY (
	`ro_br_num`
)
REFERENCES `branch` (
	`br_num`
);

ALTER TABLE `price` ADD CONSTRAINT `FK_size_TO_price_1` FOREIGN KEY (
	`si_pr_name`
)
REFERENCES `size` (
	`si_name`
);

ALTER TABLE `reservationList` ADD CONSTRAINT `FK_dog_TO_reservationList_1` FOREIGN KEY (
	`rl_d_num`
)
REFERENCES `dog` (
	`d_num`
);

ALTER TABLE `reservationList` ADD CONSTRAINT `FK_room_TO_reservationList_1` FOREIGN KEY (
	`rl_ro_num`
)
REFERENCES `room` (
	`ro_num`
);

ALTER TABLE `reservationList` ADD CONSTRAINT `FK_reservation_TO_reservationList_1` FOREIGN KEY (
	`rl_re_num`
)
REFERENCES `reservation` (
	`re_num`
);

ALTER TABLE `point` ADD CONSTRAINT `FK_member_TO_point_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_member_TO_reservation_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);
