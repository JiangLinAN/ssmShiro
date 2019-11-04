package com.jla.pojo;

import com.alibaba.druid.filter.AutoLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * CREATE TABLE `user_jla` (
 *
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(100) DEFAULT NULL,
 *   `password` varchar(100) DEFAULT NULL,
 *   `salt` varchar(100) DEFAULT NULL,
 *   `gender` varchar(4) DEFAULT NULL,
 *   `regist_time` date DEFAULT NULL,
 *   `claz_id` int(11) DEFAULT NULL,
 *
 *   PRIMARY KEY (`id`),
 *   KEY `For` (`claz_id`),
 *   CONSTRAINT `For` FOREIGN KEY (`claz_id`) REFERENCES `claz_jla` (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 * @Author:蒋林安
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String gender;
    private Date registTime;
    private Integer clazId;

}
