# dataroom
## 20201215 注册登陆
创建数据库dataroom
创建表

```sql
CREATE TABLE `user` (
                        `id` bigint(32) NOT NULL AUTO_INCREMENT,
                        `username` varchar(20) DEFAULT NULL,
                        `password` varchar(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `user` VALUES (1, 'zjm', '123');
INSERT INTO `user` VALUES (2, 'wn', '123');
```

注册页面
http://localhost:8888/regist.html
登陆页面
http://localhost:8888/login.html


