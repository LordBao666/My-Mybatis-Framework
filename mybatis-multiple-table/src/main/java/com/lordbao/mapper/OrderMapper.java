package com.lordbao.mapper;

import com.lordbao.beans.Order;

/**
 * @Author Lord_Bao
 * @Date 2024/8/2 15:40
 * @Version 1.0
 */
public interface OrderMapper {
    Order selectOrderWithCustomer(Integer orderId);
}
