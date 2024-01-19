package com.async.orderfullfillasync.service;


import com.async.orderfullfillasync.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderFulFill {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private InventoryService inventoryService;

    /* All Required process */
    /*
      1. Inventory service check order availability
      2. Process payment for order
      Till here we need tasks to be executed Synchronously
      From Step 3 we need to execute task in Background using Other thread
      3. Notify to the user
      4. Assign to vendor
      5. packaging
      6. assign delivery partner
      7. assign trailer
      8. dispatch product
      **/

    public Order processOrder(Order order) throws InterruptedException {
        order.setTrackingId(UUID.randomUUID().toString());
        if(inventoryService.isProductAvailable(order.getProductId())){
            paymentService.processPayment(order);
        }
        else {
            throw new RuntimeException("Service Downtime");
        }
        return order;
    }

    @Async("asyncTaskExecutor")
    public void notifyUser(Order order) throws InterruptedException{
        Thread.sleep(4000L);
        log.info("Notified User {}",Thread.currentThread().getName());
    }


    @Async("asyncTaskExecutor")
    public void assignVendor(Order order)throws InterruptedException{
        Thread.sleep(5000L);
        log.info("Product Order Assigned to vendor {} ",Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void packagingOrder(Order order)throws InterruptedException{
        Thread.sleep(3000L);
        log.info("packaging order {} ",Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignDelivery(Order order)throws InterruptedException{
        Thread.sleep(10000L);
        log.info("Assigning Delivery {} ",Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignTrailerAndDispatch(Order order)throws InterruptedException{
        log.info("Order Dispatched {} ",Thread.currentThread().getName());
        Thread.sleep(6000L);
    }





}
