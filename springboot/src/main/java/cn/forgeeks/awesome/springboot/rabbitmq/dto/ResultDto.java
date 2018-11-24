package cn.forgeeks.awesome.springboot.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ResultDto implements Serializable {
    Integer code ;
    Object msg;
}
