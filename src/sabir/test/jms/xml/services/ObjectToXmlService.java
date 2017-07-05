package sabir.test.jms.xml.services;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import sabir.test.jms.entity.Message;  



public class ObjectToXmlService {
	public static void convertObjectToXml (Object object) throws IOException, JAXBException
	{
		
	
	JAXBContext contextObj = JAXBContext.newInstance(object.getClass());  
	  
    Marshaller marshallerObj = contextObj.createMarshaller();  
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
    
    File file = new File(object.getClass().getSimpleName());
	

    System.out.println (object.getClass().getName() );
    FileOutputStream xmlFile = new FileOutputStream(file);
    if (!( file).exists()) {
    	file.createNewFile();
	}
    marshallerObj.marshal(object, xmlFile);  
  
	} 
	

}
