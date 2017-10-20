package com.perficient.SpringH2Sample.controller;


import com.perficient.SpringH2Sample.IService.ISubscriberService;
import com.perficient.SpringH2Sample.domain.Subscriber;
import com.perficient.SpringH2Sample.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequestMapping(value="subscriber")
@Controller
public class SubscriberController {
    @Autowired
    private ISubscriberService iSubscriberService;

    @RequestMapping(value="test")
    public String test(){
        return "Success";
    }

    @RequestMapping( value="add", method = RequestMethod.POST)
    public @ResponseBody String addSubscriber(@RequestBody Subscriber sub, HttpServletResponse response){

        System.out.println("Name "+sub.getName());
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return  iSubscriberService.add(sub);



    }
    @RequestMapping( value="get", method = RequestMethod.GET)
    public @ResponseBody Subscriber getSubscriber(@RequestParam("id") int id){

        //System.out.println("Name "+sub.getName());

        return  iSubscriberService.get(id);



    }

    @RequestMapping( value="getE", method = RequestMethod.GET)
    public @ResponseBody Subscriber getError() throws Exception {

        //System.out.println("Name "+sub.getName());
        throw  new Exception();




    }

    @RequestMapping( value="get400", method = RequestMethod.POST)
    public ResponseEntity<?> getError(HttpServletResponse response)  {

        //System.out.println("Name "+sub.getName());

        return  new ResponseEntity< >("400 Bad Request",HttpStatus.BAD_REQUEST);


    }

    @RequestMapping( value="getSleep", method = RequestMethod.POST)
    public void getSleep(HttpServletResponse response) throws InterruptedException {

        //System.out.println("Name "+sub.getName());
         Thread t = new Thread();

         Thread.sleep(60000);

        //return  new ResponseEntity< >("400 Bad Request",HttpStatus.BAD_REQUEST);


    }


}
