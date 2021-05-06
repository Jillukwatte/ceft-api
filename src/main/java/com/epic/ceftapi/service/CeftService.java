package com.epic.ceftapi.service;
 
import com.epic.ceft.bean.CeftResponse;
import com.epic.ceft.bean.Session; 

public interface CeftService {

	CeftResponse tolpConnector ( Session ceftRequest);
	
}
