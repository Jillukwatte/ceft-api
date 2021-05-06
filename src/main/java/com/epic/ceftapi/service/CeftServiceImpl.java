package com.epic.ceftapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epic.ceft.bean.CeftResponse;
import com.epic.ceft.bean.Session;
import com.epic.ceftapi.queue.ProduceAcquirer;  
 
@Service
public class CeftServiceImpl implements CeftService{
   
	@Autowired
	ProduceAcquirer RabbitMQProducer; 
	
	@Override 
	public CeftResponse tolpConnector(Session s) { 
		CeftResponse ceftResponse =new CeftResponse(); 
		try {
			 
			return RabbitMQProducer.ConvertAndSendtoConsumer(s); 
			
		} catch (Exception e) {
			 
			ceftResponse.setDescription("Exception "+e.getMessage()); 
			ceftResponse.setResponsecode("E103"); 
			ceftResponse.setUuid("");
			return ceftResponse;
		} 
		
		
	}
	
 
	 
}
