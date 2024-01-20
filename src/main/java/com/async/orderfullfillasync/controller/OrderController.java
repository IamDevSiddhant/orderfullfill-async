package com.async.orderfullfillasync.controller;


import com.async.orderfullfillasync.dto.Order;
import com.async.orderfullfillasync.service.OrderFulFill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OrderController {

    @Autowired
    private OrderFulFill orderFulFillService;


    @PostMapping("/order")
    public ResponseEntity<?> saveProduct(@RequestBody Order order)throws InterruptedException{
        orderFulFillService.processOrder(order);
        orderFulFillService.notifyUser(order);
        orderFulFillService.assignVendor(order);
        orderFulFillService.packagingOrder(order);
        orderFulFillService.assignDelivery(order);
        orderFulFillService.assignTrailerAndDispatch(order);
        return ResponseEntity.ok(order);
    }


}
