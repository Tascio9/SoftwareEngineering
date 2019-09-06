/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_juneclient;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author biar
 */
class Listener implements MessageListener {

    public Listener() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
 
                try { // Call Web Service Operation
                    com.mycompany.exam_juneserver.PMImplService service = new com.mycompany.exam_juneserver.PMImplService();
                    com.mycompany.exam_juneserver.ProfessorManagement port = service.getPMImplPort();
                    // TODO initialize WS operation arguments here
                    java.lang.String arg0 = msg.getStringProperty("Id");
                    // TODO process result here
                    java.lang.String result = port.getDetails(arg0);
                    System.out.println(msg.getText() + " ... bravo " + result);
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
           
            } else {
                System.out.println("Message of wrong type: "
                        + message.getClass().getName());
            }
        } catch (Throwable t) {
            System.out.println("Exception in onMessage():" + t.getMessage());
        }
    }
}
