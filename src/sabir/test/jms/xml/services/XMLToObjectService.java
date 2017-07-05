package sabir.test.jms.xml.services;

import java.io.File;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;

import sabir.test.jms.entity.Message;  
  
public class XMLToObjectService {  
	
	
public static Object XMLToObjectService ( File file , Object object)throws JAXBException
{ 
	 JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass()); 
	 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
	 object= jaxbUnmarshaller.unmarshal(file);  
	 return object; 
	 
}

}  