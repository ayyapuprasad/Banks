package com.extend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.NotificationRequestDto;
import com.extend.bean.SubscriptionRequestDto;
import com.extendservice.impl.NotificationServiceImpl;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationServiceimpl;

    @PostMapping("/subscribe")
    public void subscribeToTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        notificationServiceimpl.subscribeToTopic(subscriptionRequestDto);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribeFromTopic(SubscriptionRequestDto subscriptionRequestDto) {
      notificationServiceimpl.unsubscribeFromTopic(subscriptionRequestDto);
    }

    @PostMapping("/token")
    public String sendPnsToDevice(@RequestBody NotificationRequestDto notificationRequestDto) {
        return notificationServiceimpl.sendPnsToDevice(notificationRequestDto);
    }

  @PostMapping("/topic")
    public String sendPnsToTopic(@RequestBody NotificationRequestDto notificationRequestDto) {
        return notificationServiceimpl.sendPnsToTopic(notificationRequestDto);
    }
}

