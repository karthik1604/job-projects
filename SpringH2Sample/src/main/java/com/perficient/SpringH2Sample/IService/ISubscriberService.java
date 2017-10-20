package com.perficient.SpringH2Sample.IService;
;
import com.perficient.SpringH2Sample.domain.Subscriber;

public interface ISubscriberService {

    public String add(Subscriber sub);
    public Subscriber get(int id);
}
