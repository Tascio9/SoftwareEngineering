/*
 * Tutorial n°2: Work Queues
 */
package com.mycompany.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import java.util.Scanner;

/**
 *
 * @author biar
 */
public class NewTask {

    private final static String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
            while(true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                channel.basicPublish("", "task_queue",
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            }
        }
    }

}
