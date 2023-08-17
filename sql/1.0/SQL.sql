CREATE
DATABASE `heartbeat_feeling`;

USE
`heartbeat_feeling`;

CREATE TABLE `hf_user`
(
    `openid`        varchar(255) NOT NULL COMMENT '用户openid',
    `unionid`       varchar(255) NOT NULL COMMENT '用户unionid',
    `user_code`     varchar(255) DEFAULT NULL COMMENT '用户编码',
    `user_name`     varchar(255) DEFAULT NULL COMMENT '用户名称',
    `nick_name`     varchar(255) DEFAULT NULL COMMENT '用户昵称',
    `avatar_url`    varchar(255) DEFAULT NULL COMMENT '用户微信头像',
    `gender`        tinyint      DEFAULT NULL COMMENT '性别：1：男，2：女，0：未知',
    `age`           int          DEFAULT NULL COMMENT '年龄',
    `birthday`      datetime     DEFAULT NULL COMMENT '出生日期',
    `marital`       varchar(255) DEFAULT NULL COMMENT '婚姻状况',
    `education`     varchar(255) DEFAULT NULL COMMENT '学历',
    `income`        varchar(255) DEFAULT NULL COMMENT '收入',
    `country`       varchar(255) DEFAULT NULL COMMENT '国家',
    `province`      varchar(255) DEFAULT NULL COMMENT '省',
    `city`          varchar(255) DEFAULT NULL COMMENT '市',
    `town`          varchar(255) DEFAULT NULL COMMENT '区',
    `address`       varchar(255) DEFAULT NULL COMMENT '地址',
    `language`      varchar(255) DEFAULT NULL COMMENT '语言',
    `phone`         varchar(255) DEFAULT NULL COMMENT '手机号码',
    `identity_card` varchar(255) DEFAULT NULL COMMENT '身份证号码',
    `level`         tinyint      DEFAULT NULL COMMENT '用户等级：1：普通用户，2：会员用户',
    `create_by`     varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`openid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

CREATE TABLE `hf_user_detail`
(
    `openid`      varchar(255) NOT NULL COMMENT '用户openid',
    `profession`  varchar(255) DEFAULT NULL COMMENT '职业',
    `height`      varchar(255) DEFAULT NULL COMMENT '身高（单位：cm）',
    `weight`      varchar(255) DEFAULT NULL COMMENT '体重（单位：kg）',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`openid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户详细信息';

CREATE TABLE `hf_user_note`
(
    `openid`      varchar(255) NOT NULL COMMENT '用户openid',
    `note`        varchar(255) DEFAULT NULL COMMENT '备注信息',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`openid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户备注信息';

CREATE TABLE `hf_user_image`
(
    `id`        int          NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `openid`    varchar(255) NOT NULL COMMENT '用户openid',
    `image_url` varchar(255) DEFAULT NULL COMMENT '用户照片地址',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户照片';

CREATE TABLE `hf_user_interest`
(
    `id`          int          NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `openid`      varchar(255) NOT NULL COMMENT '用户openid',
    `interest`    varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户兴趣爱好';

CREATE TABLE `hf_interest`
(
    `id`       int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `type`     varchar(255) DEFAULT NULL COMMENT '兴趣爱好类型',
    `interest` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='兴趣爱好';

INSERT INTO `hf_interest`(`interest`)
VALUES ('阅读'),
       ('电影'),
       ('听歌'),
       ('画画'),
       ('旅游');

CREATE TABLE `hf_user_love_standard`
(
    `id`            int          NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `openid`        varchar(255) NOT NULL COMMENT '用户openid',
    `love_standard` varchar(255) DEFAULT NULL COMMENT '恋爱标准',
    `create_by`     varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户恋爱标准';

CREATE TABLE `hf_love_standard`
(
    `id`            int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `type`          varchar(255) DEFAULT NULL COMMENT '恋爱标准类型',
    `love_standard` varchar(255) DEFAULT NULL COMMENT '恋爱标准',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='恋爱标准';

INSERT INTO `hf_love_standard`(`love_standard`)
VALUES ('不抽烟'),
       ('不喝酒');

CREATE TABLE `hf_user_vip`
(
    `id`             int          NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `openid`         varchar(255) NOT NULL COMMENT '用户openid',
    `vip_start_time` datetime    DEFAULT NULL COMMENT '会员开始时间',
    `vip_end_time`   datetime    DEFAULT NULL COMMENT '会员结束时间',
    `create_by`      varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(50) DEFAULT NULL COMMENT '修改人',
    `update_time`    datetime    DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户会员';

CREATE TABLE `hf_user_authentication`
(
    `id`          int          NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `openid`      varchar(255) NOT NULL COMMENT '用户openid',
    `type`        varchar(255) DEFAULT NULL COMMENT '认证类型',
    `information` varchar(255) DEFAULT NULL COMMENT '认证信息',
    `image_url`   varchar(255) DEFAULT NULL COMMENT '认证图片',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户认证';