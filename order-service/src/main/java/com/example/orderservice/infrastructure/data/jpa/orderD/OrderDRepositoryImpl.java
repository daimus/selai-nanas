package com.example.orderservice.infrastructure.data.jpa.orderD;

import com.example.orderservice.application.order.entity.OrderD;
import com.example.orderservice.application.order.repository.OrderDRepository;
import com.example.orderservice.infrastructure.data.jpa.orderD.JpaOrderDRepository;
import com.example.orderservice.infrastructure.data.jpa.orderD.OrderDEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderDRepositoryImpl implements OrderDRepository {
    private final JpaOrderDRepository jpaOrderRepository;

    @Override
    public List<OrderD> findAll() {
        List<OrderDEntity> orderDEntities = (List<OrderDEntity>) jpaOrderRepository.findAll();
        List<OrderD> OrderD = new ArrayList<>();
        for (OrderDEntity orderEntity : orderDEntities){
            OrderD order = new OrderD();
            BeanUtils.copyProperties(orderEntity, order);
            OrderD.add(order);
        }
        return OrderD;
    }

    @Override
    public OrderD findById(Long id) {
        Optional<OrderDEntity> orderEntities = jpaOrderRepository.findById(id);
        if (orderEntities.isEmpty()){
            throw new NoSuchElementException();
        }
        OrderD order = new OrderD();
        BeanUtils.copyProperties(orderEntities.get(), order);
        return order;
    }

    @Override
    public OrderD save(OrderD order) {
        OrderDEntity orderEntities = new OrderDEntity();
        BeanUtils.copyProperties(order, orderEntities);
        orderEntities = jpaOrderRepository.save(orderEntities);
        BeanUtils.copyProperties(orderEntities, order);
        return order;
    }

    @Override
    public boolean deleteById(Long id) {
        jpaOrderRepository.deleteById(id);
        return true;
    }

}
