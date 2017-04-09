package com.chen.test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by CHEN on 2017/4/9.
 */
public abstract class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endPointName) throws IOException {
        this.endPointName = endPointName;

        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");

        connection=factory.newConnection();
        channel=connection.createChannel();

        channel.queueDeclare(endPointName,false,false,false,null);

    }

    public void close() throws IOException {
        this.channel.close();
        this.connection.close();
    }
}
