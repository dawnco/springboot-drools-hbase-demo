package com.nz.service;

import com.nz.entity.Discount;
import com.nz.entity.Order;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderDiscountService {

    private KieContainer kieContainer;

    @Autowired
    public void setKieContainer(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }
    public Discount getDiscount(Order order) {
        Discount discount = new Discount();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("discount", discount);
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
        return discount;
    }
}