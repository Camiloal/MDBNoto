/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author CamiloAlvarez
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/dest"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyMDB implements MessageListener {

    public MyMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {

            TextMessage tmsg = (TextMessage) message;
            System.out.println(tmsg.getText());
        } catch (JMSException ex) {
            Logger.getLogger(MyMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
