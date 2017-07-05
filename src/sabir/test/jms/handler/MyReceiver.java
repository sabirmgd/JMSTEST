package sabir.test.jms.handler;

import javax.jms.*;  
import javax.naming.*;  
import java.util.Properties;

public class MyReceiver {  
    public static void main(String[] args) {  
        try{  
            //1) Create and start connection  
        	Properties properties = new Properties();
        	properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        	properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        	properties.setProperty("java.naming.provide.url", "iiop://localhost:3700");
        	
            InitialContext ctx=new InitialContext(properties);  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("java:comp/DefaultJMSConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
            //2) create Queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            //3) get the Queue object  
            Queue t=(Queue)ctx.lookup("myQueue");  
            //4)create QueueReceiver  
            QueueReceiver receiver=ses.createReceiver(t);  
              
            //5) create listener object  
            MyListener listener=new MyListener();  
              
            //6) register the listener object with receiver  
            receiver.setMessageListener(listener);  
              
            System.out.println("Receiver1 is ready, waiting for messages...");  
            System.out.println("press Ctrl+c to shutdown...");  
            while(true){                  
                Thread.sleep(1000);  
            }  
        }catch(Exception e){System.out.println(e);}  
    }  
  
}  