package com.stackroute.profilemicroservice.RealTimeChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MessageController {

  private static final String SENDING_URL = "/topic/server-broadcaster";
  private static final String RECEIVING_URL = "/server-receiver";

  private AtomicLong counter = new AtomicLong(0);
  private Integer message;

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

  @Scheduled(fixedRate = 2000)
  public void sendMessage() {
    RealData data = buildNextMessage();
    System.out.println("Sending message::->" + data.toString());
    messagingTemplate.convertAndSend(SENDING_URL, data);
  }

  // Building random message with value
  private RealData buildNextMessage() {
    String chars = "abcxyz";
    message = (int) Math.random();
    Random random = new Random();
    Random rnd = new Random();
    char c = chars.charAt(rnd.nextInt(chars.length()));

    // Finding random character among a b c x y z
    chars.charAt(rnd.nextInt(chars.length()));

    // Finding a random num btw 0 to 50
    int value = random.ints(0,(50+1)).findFirst().getAsInt();
    /*
    * Sending out message object as { character: aval, value: 40 }
    * */
    RealData messageData = new RealData(c+"val", value);

    return messageData;
  }

  @MessageMapping("/websocket")
  public void publishMessage(Activity activityMessage) throws Exception {
    this.messagingTemplate.convertAndSendToUser("realtimechat", "/socketmsg", activityMessage);
  }
}
