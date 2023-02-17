package com.example.orderservice.infrastructure.data.jpa.orderitem;

import com.example.orderservice.application.cart.entity.Cart;
import com.example.orderservice.application.orderitem.entity.OrderItem;
import com.example.orderservice.application.orderitem.repository.OrderItemRepository;
import com.example.orderservice.infrastructure.data.jpa.cart.CartEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepository {
    private final JpaOrderItemRepository jpaOrderItemRepository;

    @Override
    public void saveAll(List<OrderItem> orderItems) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        for (OrderItem orderItem : orderItems){
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            BeanUtils.copyProperties(orderItem, orderItemEntity);
            orderItemEntities.add(orderItemEntity);
        }
        jpaOrderItemRepository.saveAll(orderItemEntities);
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(Long orderId) {
        List<OrderItemEntity> orderItemEntities = jpaOrderItemRepository.findAllByOrderId(orderId);
        return this.castOrderItemEntityToOrderItem(orderItemEntities);
    }

    private List<OrderItem> castOrderItemEntityToOrderItem(List<OrderItemEntity> orderItemEntities){
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemEntity orderItemEntity : orderItemEntities){
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(orderItemEntity, orderItem);
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
