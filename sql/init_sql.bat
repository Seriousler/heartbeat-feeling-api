#!/bin/bash
HOSTNAME="rm-cn-uax3a17ac001gayo.rwlb.rds.aliyuncs.com"
PORT="3306"
USERNAME="root"
PASSWORD="Zhanglong4160"
DBNAME="heartbeat_feeling"

#连接数据库并执行sql语句
mysql -h${HOSTNAME}  -P${PORT}  -u${USERNAME} -p${PASSWORD}<<EOF
use ${DBNAME}
SELECT * FROM sys_config;
EOF