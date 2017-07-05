package sabir.test.jms.entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import java.io.Serializable;

@Entity
@Table(name ="MESSAGES")
@XmlRootElement  
public class Message implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id; 
	private String type;
	
	private String senderName;
	private String recieverName;
	
	private String senderBankName;
	private String recieverBankName;
	
	private long amount;

	public Message() {} 
	public Message(String id, String type, String senderName, String recieverName, String senderBankName,
			String recieverBankName, long amount) {
		//super();
		this.id = id;
		this.type = type;
		this.senderName = senderName;
		this.recieverName = recieverName;
		this.senderBankName = senderBankName;
		this.recieverBankName = recieverBankName;
		this.amount = amount;
	}

	@XmlAttribute  
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	@XmlElement
	public String getRecieverName() {
		return recieverName;
	}
	
	
	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	@XmlElement
	public String getSenderBankName() {
		return senderBankName;
	}

	public void setSenderBankName(String senderBankName) {
		this.senderBankName = senderBankName;
	}
	
	@XmlElement
	public String getRecieverBankName() {
		return recieverBankName;
	}

	public void setRecieverBankName(String recieverBankName) {
		this.recieverBankName = recieverBankName;
	}
	
	@XmlElement
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	

}
