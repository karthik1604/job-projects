package com.perficient.SpringH2Sample.serviceImpl;

import com.perficient.SpringH2Sample.IService.ISubscriberService;
import com.perficient.SpringH2Sample.domain.Subscriber;
import org.springframework.stereotype.Service;


public class DummySubscriberServiceDB implements ISubscriberService {
    @Override
    public String add(Subscriber sub) {

        return "Static Success";
    }

    @Override
    public Subscriber get(int id) {
        return null;
    }
}
