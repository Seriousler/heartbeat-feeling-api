USE
`heartbeat_feeling`;

CREATE TABLE `hf_user`
(
    `id`            int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_code`     varchar(255) DEFAULT NULL COMMENT '用户编码',
    `user_name`     varchar(255) DEFAULT NULL COMMENT '用户名称',
    `nickname`      varchar(255) DEFAULT NULL COMMENT '用户昵称',
    `sex`           tinyint      DEFAULT NULL COMMENT '性别：1：男，2：女',
    `age`           int          DEFAULT NULL COMMENT '年龄',
    `birthday`      datetime     DEFAULT NULL COMMENT '出生日期',
    `marital`       varchar(255) DEFAULT NULL COMMENT '婚姻状况',
    `education`     varchar(255) DEFAULT NULL COMMENT '学历',
    `income`        varchar(255) DEFAULT NULL COMMENT '收入',
    `province`      varchar(255) DEFAULT NULL COMMENT '省',
    `city`          varchar(255) DEFAULT NULL COMMENT '市',
    `town`          varchar(255) DEFAULT NULL COMMENT '区',
    `address`       varchar(255) DEFAULT NULL COMMENT '地址',
    `phone`         varchar(255) DEFAULT NULL COMMENT '手机号码',
    `identity_card` varchar(255) DEFAULT NULL COMMENT '身份证号码',
    `level`         tinyint      DEFAULT NULL COMMENT '用户等级：1：普通用户，2：会员用户',
    `CREATE_BY`     varchar(255) DEFAULT NULL COMMENT '创建人',
    `CREATE_TIME`   datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_BY`     varchar(255) DEFAULT NULL COMMENT '修改人',
    `UPDATE_TIME`   datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

CREATE TABLE `hf_user_image`
(
    `id`        int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_code` varchar(255) DEFAULT NULL COMMENT '用户编码',
    `image_url` varchar(255) DEFAULT NULL COMMENT '用户照片地址',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户照片';

CREATE TABLE `hf_user_interest`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_code`   varchar(255) DEFAULT NULL COMMENT '用户编码',
    `interest`    varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
    `CREATE_BY`   varchar(255) DEFAULT NULL COMMENT '创建人',
    `CREATE_TIME` datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_BY`   varchar(255) DEFAULT NULL COMMENT '修改人',
    `UPDATE_TIME` datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='兴趣爱好';

CREATE TABLE `hf_love_standard`
(
    `id`            int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_code`     varchar(255) DEFAULT NULL COMMENT '用户编码',
    `love_standard` varchar(255) DEFAULT NULL COMMENT '恋爱标准',
    `CREATE_BY`     varchar(255) DEFAULT NULL COMMENT '创建人',
    `CREATE_TIME`   datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_BY`     varchar(255) DEFAULT NULL COMMENT '修改人',
    `UPDATE_TIME`   datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='恋爱标准';

CREATE TABLE `hf_user_vip`
(
    `id`             int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_code`      varchar(255) DEFAULT NULL COMMENT '用户编码',
    `vip_start_time` datetime     DEFAULT NULL COMMENT '会员开始时间',
    `vip_end_time`   datetime     DEFAULT NULL COMMENT '会员结束时间',
    `CREATE_BY`      varchar(255) DEFAULT NULL COMMENT '创建人',
    `CREATE_TIME`    datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_BY`      varchar(255) DEFAULT NULL COMMENT '修改人',
    `UPDATE_TIME`    datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户会员';

CREATE TABLE `hf_user_authentication`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_code`   varchar(255) DEFAULT NULL COMMENT '用户编码',
    `type`        varchar(255) DEFAULT NULL COMMENT '认证类型',
    `information` varchar(255) DEFAULT NULL COMMENT '认证信息',
    `image_url`   varchar(255) DEFAULT NULL COMMENT '认证图片',
    `CREATE_BY`   varchar(255) DEFAULT NULL COMMENT '创建人',
    `CREATE_TIME` datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_BY`   varchar(255) DEFAULT NULL COMMENT '修改人',
    `UPDATE_TIME` datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户认证';