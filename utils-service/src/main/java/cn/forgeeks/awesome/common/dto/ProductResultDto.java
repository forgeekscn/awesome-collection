package cn.forgeeks.awesome.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResultDto implements Serializable {
    private Long productId;
    private String productName;
    private String productDesc;
    private String productCategory;
    private Double productPrice;
    private String productMaster ;
    private String productShopName;
    private String productPic;
    private Boolean onSale;
    private Long saleNumber;
    private String createTime;
    private Float score;
    private String id;
}
