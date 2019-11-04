package com.jla.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 CREATE TABLE `perm_jla` (

 `id` int(11) NOT NULL,
 `perm` varchar(100) DEFAULT NULL,
 `create_time` date DEFAULT NULL,

 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 * @Author:蒋林安
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perm {
    private Integer id;
    private String perm;
    private Date createTime;
}
