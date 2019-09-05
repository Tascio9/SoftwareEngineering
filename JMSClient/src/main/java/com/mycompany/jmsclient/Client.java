/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmsclient;

import java.util.Properties;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author biar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Context jndiContext = null;
        ConnectionFactory topicConnectionFactory = null;
        
        String destinationName = "dynamicTopics/Quotazioni";
        
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
