package com.epic.ceftapi.configs;

import java.util.ArrayList; 
import java.util.List;
import org.springframework.context.annotation.Configuration; 
 
@Configuration
public class Configurations {
	public final static String entity_package_mysql="com.epic.ceftapi.entity.mysql";
	public final static String repository_package_mysql="com.epic.ceftapi.repository.mysql";
	
	public static List<String> txntypeList = new ArrayList<String>();
	public static List<String> excludemobileList = new ArrayList<String>();
	public static List<String> accountList = new ArrayList<String>();
	public static List<String> customeridList = new ArrayList<String>();
	 
}
