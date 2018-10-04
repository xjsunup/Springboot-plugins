DROP TABLE IF EXISTS `falyway_test`;
CREATE TABLE `falyway_test` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `change` varchar(50) NOT NULL COMMENT '改变',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `description` char(8) NOT NULL COMMENT '描述',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;