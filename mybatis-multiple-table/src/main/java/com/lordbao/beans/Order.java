package com.lordbao.beans;

import lombok.Data;

/**
 * @Author Lord_Bao
 * @Date 2024/8/2 15:01
 * @Version 1.0
 */
@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Customer customer;
}
