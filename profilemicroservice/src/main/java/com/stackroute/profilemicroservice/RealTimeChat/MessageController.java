package com.stackroute.profilemicroservice.RealTimeChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MessageController {

  private static final String SENDING_URL = "/topic/server-broadcaster";
  private static final String RECEIVING_URL = "/server-receiver";

  private AtomicLong counter = new AtomicLong(0);
  private String message = "";

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @Autowired
  public MessageController(SimpMessagingTemplate template) {
    this.messagingTemplate = template;
  }

  @MessageMapping(RECEIVING_URL)
  public void onReceivedMessage(String message) {
    System.out.println("New message received : " + message);
  }

  @SubscribeMapping(SENDING_URL)
  public String onSubscribe() {
    return "SUBSCRIBED : " + message;
  }

  @Scheduled(fixedRate = 1000)
  public void sendMessage() {
    System.out.println("Sending message::->");
    messagingTemplate.convertAndSend(SENDING_URL, buildNextMessage());
  }

  private String buildNextMessage() {
    message = "Test" + counter.getAndIncrement();
    System.out.println("Send message " + message);
    return message;
  }
  @MessageMapping("/websocket")
  public void publishMessage(Activity activityMessage) throws Exception {
    this.messagingTemplate.convertAndSendToUser("realtimechat", "/socketmsg", activityMessage);
  }
}
