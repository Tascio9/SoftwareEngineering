/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_juneclient;

import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Context jndiContext = null;
        ConnectionFactory topicConnectionFactory = null;
        
        String destinationName = "dynamicTopics/professors";
        
        
        try{

             Properties props = new Properties();
             props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
             props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
             jndiContext = new InitialContext(props);

             topicConnectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
             Destination destination = (Destination) jndiContext.lookup(destinationName);
             TopicConnection topicConnection = (TopicConnection) topicConnectionFactory.createConnection();
             TopicSession topicSession = (TopicSession) topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

             TopicSubscriber topicSubscriber
                     = topicSession.createSubscriber((Topic) destination);

            topicSubscriber.setMessageListener(new Listener());
               topicConnection.start();
            }catch(JMSException err){
                err.printStackTrace();
            }catch(NamingException err){
                err.printStackTrace();
            } 
        }
    
}
