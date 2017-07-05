package sabir.test.jms.handler;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.jms.*;

import sabir.test.jms.dao.DatabaseService;
import sabir.test.jms.entity.Message;
import sabir.test.jms.xml.services.ObjectToXmlService;
public class MySender {  
    public static void main(String[] args) {  
        try  
        {   //Create and start connection  
            InitialContext ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("java:comp/DefaultJMSConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
           
            //2) create queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
          
            //3) get the Queue object  
            Queue t=(Queue)ctx.lookup("myQueue");  
           
            //4)create QueueSender object         
            QueueSender sender=ses.createSender(t);  
            
            //5) create TextMessage object  
            ObjectMessage msg=ses.createObjectMessage();  
              
            //6) write message  
            Message msgObject = new Message ("1","MT 103", "Sabir","Banda","CIMB","May Bank", 1000);
            ObjectToXmlService.convertObjectToXml(msgObject);
            File file = new File (msgObject.getClass().getSimpleName()+".xml");
            List<File> f1 = new ArrayList<File>();
            f1.add(file);
            Master eMaster = new Master();
            ((Master) eMaster).setF(f1);
            
            //add Files here 
            msg.setObject(eMaster);
            sender.send(msg);
            
            //7) send message  
            System.out.println("Message successfully sent.");  
            
            // save the message to the database 
            DatabaseService.insertMessage(msgObject);
            
            //8) connection close  
            con.close();  
            
            
        }catch(Exception e){System.out.println(e);}  
    }  
}  