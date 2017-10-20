package com.perficient.SpringH2Sample.repository;

import com.perficient.SpringH2Sample.domain.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {

}