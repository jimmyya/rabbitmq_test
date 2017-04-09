package com.chen.test1.consumer;

import com.chen.test1.EndPoint;
import com.rabbitmq.client.*;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHEN on 2017/4/9.
 */
public class QueueConsumer extends EndPoint implements Runnable,Consumer{

    public QueueConsumer(String endPointName) throws IOException {
        super(endPointName);
    }

    public void run() {
        try {
            channel.basicConsume(endPointName,true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+consumerTag+" registered");
    }


    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map= (HashMap)SerializationUtils.deserialize(bytes);
        System.out.println("Message Number "+map.get("message number"));
    }
}
