/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_juneserver;

import javax.jms.*;
import javax.naming.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author biar
 */
public class ProductRanking {

    final String id[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

    private String scegliId() {
        int whichMsg;
        Random randomGen = new Random();

        whichMsg = randomGen.nextInt(this.id.length);
        return this.id[whichMsg];
    }

    private float valore() {
        Random randomGen = new Random();
        float val = randomGen.nextFloat() * this.id.length * 10;
        return val;
    }

    private static final Logger LOG = LoggerFactory.getLogger(ProductRanking.class);

    public void start() throws NamingException, JMSException {

        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        String destinationName = "dynamicTopics/professors";

        /*
         * Create a JNDI API InitialContext object
         */
        try {

            Properties props = new Properties();

            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            jndiContext = new InitialContext(props);

        } catch (NamingException e) {
            LOG.info("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }

        /*
         * Look up connection factory and destination.
         */
        try {
            connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            destination = (Destination) jndiContext.lookup(destinationName);
        } catch (NamingException e) {
            LOG.info("JNDI API lookup failed: " + e);
            System.exit(1);
        }

        /*
         * Create connection. Create session from connection; false means
         * session is not transacted. Create sender and text message. Send
         * messages, varying text slightly. Send end-of-messages message.
         * Finally, close connection.
         */
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);

            TextMessage message = null;
            String messageType = null;

            message = session.createTextMessage();

            float ranking;
            int i = 0;
            while (true) {
                messageType = scegliId();
                ranking = valore();
                message.setStringProperty("Id", messageType);
                message.setFloatProperty("Valore", ranking);
                message.setText(
                        "Ricevuto id : " + messageType + " con ranking: " 
                        + ranking );

                LOG.info(
                        this.getClass().getName()
                        + " Invio ranking: " + message.getText());

                producer.send(message);

                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (JMSException e) {
            LOG.info("Exception occurred: " + e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
    }
}
