package com.example.orderservice.infrastructure.data.rest.xendit;

import com.example.orderservice.application.order.entity.Order;
import com.example.orderservice.application.order.type.OrderStatus;
import com.example.orderservice.application.order.usecase.OrderUseCase;
import com.example.orderservice.event.publisher.OrderEventPublisher;
import com.xendit.Xendit;
import com.xendit.exception.XenditException;
import com.xendit.model.Invoice;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class Payment {
    @Value("${xendit.apikey}")
    String XENDIT_API_KEY;

    private final OrderUseCase orderUseCase;

    @Async
    @EventListener(condition = "@orderPredicate.orderUnpaid(#order.status)")
//    @Transactional
    public void createInvoice(Order order) throws XenditException {
        log.info("order created listener on create invoice");
        Xendit.apiKey = XENDIT_API_KEY;

        Map<String, Object> params = new HashMap<>();
        params.put("external_id", String.valueOf(order.getId()));
        params.put("amount", order.getTotal());
        params.put("description", "Invoice #123");

        Invoice invoice = Invoice.create(params);
        order.setPaymentUrl(invoice.getInvoiceUrl());
        orderUseCase.saveOrder(order);
        log.info("Invoice url: {}", invoice.getInvoiceUrl());
        log.info("Invoice created: {}", invoice);
    }
}
