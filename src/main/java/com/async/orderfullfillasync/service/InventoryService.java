package com.async.orderfullfillasync.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService {

    public boolean isProductAvailable(int id){
        return true;
    }

}
