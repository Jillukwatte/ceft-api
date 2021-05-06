package com.epic.ceftapi.controller;
 
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.epic.ceft.bean.CeftRequest;
import com.epic.ceft.bean.CeftResponse;
import com.epic.ceft.bean.Session;
import com.epic.ceftapi.service.CeftService; 

@RestController
public class CeftController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CeftController.class);
	 
	@Autowired
	CeftService ceftService; 
	 
//	localhost:6971/ceft/acquire
	@GetMapping("/ceft/acquire")
    public CeftResponse notify_alert_Handler() {
		CeftRequest ceftRequest = new CeftRequest();
		CeftResponse ceftResponse=new CeftResponse();
		final String generateduuid = UUID.randomUUID().toString().replace("-", "").toUpperCase(); 
		Marker uuid = MarkerFactory.getMarker(generateduuid);
		
		
		
		ceftRequest.setUuid(generateduuid);
		ceftRequest.setAccountno("791");
		ceftRequest.setAvlbalance("10.00 LKR");
		ceftRequest.setMobile("94719247615");
		ceftRequest.setTxnamount("452.14 LKR");
		Session s = new Session();
		s.setCeftRequest(ceftRequest);
		
		LOGGER.info(uuid, "Consumed : {}" ,ceftRequest.toString()); 
		
		ceftResponse = ceftService.tolpConnector(s);
		ceftResponse.setUuid(generateduuid);
		
		
		LOGGER.info(uuid, "Recieved : {}" ,ceftResponse.toString()); 
		return ceftResponse ; 
    } 
	
	@GetMapping("/alert") 
	public String getMessage(@RequestParam String name) {
		System.out.println("name : "+name);
		return "Greetings...! Use this to send SMS alerts"; 
	}
	 
	 
}
