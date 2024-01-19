package com.async.orderfullfillasync.service;


import com.async.orderfullfillasync.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public void processPayment(Order order) throws InterruptedException {
      log.info("initiating Payment of order {} ",order.getProductId());
      Thread.sleep(2000L);
      log.info("completed payment of order {} ",order.getProductId());
    }
}
