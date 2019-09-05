/*
 * Tutorial n°4: Routing
 */
package com.mycompany.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.Scanner;

public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            
            Scanner scanner = new Scanner(System.in);
            
            while(true){
                System.out.print(" [x] Insert severity: ");
                String severity = scanner.nextLine();           
                System.out.print(" [x] Insert message: ");
                String message = scanner.nextLine();

                //String severity = getSeverity(argv);
                //String message = getMessage(argv);

                channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
            }
        }
    }
    
}
