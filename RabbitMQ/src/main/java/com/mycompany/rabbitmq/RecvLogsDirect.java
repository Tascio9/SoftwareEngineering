/*
 * Tutorial n°5: Topic
 */
package com.mycompany.rabbitmq;

import com.rabbitmq.client.*;
import java.util.Scanner;

/**
 *
 * @author biar
 */
public class RecvLogsDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        
        Scanner scannerInt = new Scanner(System.in);       
        
        System.out.print(" [x] Insert number of parameters: ");
        int num = scannerInt.nextInt();
        
        Scanner scanner = new Scanner(System.in);
        String severity = new String();
        
        for (int i=0; i<num; i++){
            System.out.print(" [x] Usage: ReceiveLogsDirect [info] [warning] [error]: ");
            severity = scanner.nextLine();
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
        }
        
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '"
                    + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
