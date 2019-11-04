package com.jla.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 班级表
 * CREATE TABLE `claz_jla` (
 *
 *   `id` int(11) NOT NULL,
 *   `clazname` varchar(100) DEFAULT NULL,
 *   `create_time` date DEFAULT NULL,
 *
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 * @Author:蒋林安
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claz {
private Integer id;
private String clazName;
private Date createTime;
}
