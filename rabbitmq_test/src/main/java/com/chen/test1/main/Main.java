package com.chen.test1.main;

import com.chen.test1.consumer.QueueConsumer;
import com.chen.test1.producer.Producer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;

/**
 * Created by CHEN on 2017/4/9.
 */
public class Main {
    public static void main(String[] args) {
        try {
            QueueConsumer consumer=new QueueConsumer("queue");
            Thread consumerThread=new Thread(consumer);
            consumerThread.start();

            Producer producer=new Producer("queue");
            for (int i = 0; i <100000 ; i++) {
                HashMap message=new HashMap();
                message.put("message number",i);
                producer.sendMessage(message);
                System.out.println("Message Number "+i+"send");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
