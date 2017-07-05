package sabir.test.jms.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.*;  
public class MyListener implements MessageListener {  
  
    public void onMessage(Message m) {  
        try{  
        	   Master em =null;
        	   if (m instanceof ObjectMessage
                       && ((ObjectMessage) m).getObject() instanceof Master) {
                   em = (Master) ((ObjectMessage) m).getObject();
                   //use this and get list of xml file and iterate and process xml file by 
                   //below link
                   List<File> f=new ArrayList<File>();
                   f =     em.getF();
                   System.out.println(f.get(0).getName());
                   try (BufferedReader br = new BufferedReader(new FileReader(f.get(0).getName()+ ".xml"))) {
                
                	   String line = null;
                	   while ((line = br.readLine()) != null) {
                	       System.out.println(line);
                	   }
                	} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               }
        }catch(JMSException e){System.out.println(e);}  
    }  
}  