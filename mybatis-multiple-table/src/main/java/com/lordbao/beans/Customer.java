package com.lordbao.beans;

import lombok.Data;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/2 15:00
 * @Version 1.0
 */
@Data
public class Customer {
    private Integer customerId;
    private String customerName;
    private List<Order> orderList;
}
