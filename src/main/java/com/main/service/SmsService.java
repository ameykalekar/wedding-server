package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {
	
	

	
	public Boolean sendSMS( String contactno, String messageTxt,String type )
	{
		RestTemplate restTemplate = new RestTemplate();
		String senderID= "";
		String messagetye="";
		if(type.equalsIgnoreCase("promotional"))
				{
			senderID="WEBSMS";
			messagetye="1";
			
				}else
				{
					senderID="ADJTNT";
					messagetye="2";
				}
		String url="http://apps.smslane.com/vendorsms/pushsms.aspx?apikey=EAAE104E-1092-4E94-A554-EF5416DC2D40&sid="+senderID+"&fl=0"+"&msisdn="+"91"+contactno+"&msg=" +messageTxt;
		 String response=restTemplate.getForObject(url, String.class);
	System.out.println(response);
	return true;
	}
	
	
	public static void main(String[] args) {
		SmsService service = new SmsService();
		service.sendSMS("8888606658", "Welcome to maere hamsafar","promotional");
	}
	
	
	

}
