package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

// UUID is not required here for this value project
// as id order is important for the aggregate coz 
public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long id) {
        super(id);
    }
}
