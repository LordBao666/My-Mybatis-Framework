package com.lordbao.mapper;

import com.lordbao.beans.Customer;

/**
 * @Author Lord_Bao
 * @Date 2024/8/2 17:04
 * @Version 1.0
 */
public interface CustomerMapper {
    Customer selectCustomerWithOrderList(Integer customerId);
}
