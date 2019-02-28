package cn.forgeeks.awesome.springboot.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDO implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

}