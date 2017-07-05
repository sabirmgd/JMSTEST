package sabir.test.jms.dao;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import sabir.test.jms.entity.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

	
	public class DatabaseService {

		private static final String PERSISTENCE_UNIT_NAME = "testJPA";
	    private static EntityManagerFactory factory   = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
	
	    
	    public static void insertMessage(Message msg){
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
	        em.persist( msg );
	        em.getTransaction().commit();
	        em.close();
	      }
	    
	    public static Message getMessage(String id){
	        EntityManager em = factory.createEntityManager();
	      return   em.find(Message.class, id);
	      }
	    
	    public static void main (String args[])
	    {
	    	 Message msgObject = new Message ("2","MT 103", "Sabir","Banda","CIMB","May Bank", 1000);
	    	insertMessage( msgObject);
	    }
	    }

		
		

	
