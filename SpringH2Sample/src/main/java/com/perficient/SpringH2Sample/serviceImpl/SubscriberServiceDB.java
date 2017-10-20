package com.perficient.SpringH2Sample.serviceImpl;

import com.perficient.SpringH2Sample.IService.ISubscriberService;
import com.perficient.SpringH2Sample.domain.Subscriber;
import com.perficient.SpringH2Sample.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


public class SubscriberServiceDB implements ISubscriberService {

    private SubscriberRepository subscriberRepository;
    public SubscriberServiceDB(SubscriberRepository subscriberRepository){
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public String add(Subscriber sub) {
        try {
            subscriberRepository.save(sub);
        }catch(Exception e){
            e.printStackTrace();
            return  "failed";
        }

        return "success";
    }


    @Cacheable(value="subscribers" , key = "#id")
    public Subscriber get(int id){
        return subscriberRepository.findOne(id);
    }
}
