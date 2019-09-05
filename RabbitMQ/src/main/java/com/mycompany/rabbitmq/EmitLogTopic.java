/*
 * Tutorial n°5: Topic
 */
package com.mycompany.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.Scanner;

/**
 *
 * @author biar
 */
public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print(" [x] Insert RoutingKey: ");
                String routingKey = scanner.nextLine();
                System.out.print(" [x] Insert Message: ");
                String message = scanner.nextLine();

                //String severity = getSeverity(argv);
                //String message = getMessage(argv);
                
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
            }
        }
    }
}
