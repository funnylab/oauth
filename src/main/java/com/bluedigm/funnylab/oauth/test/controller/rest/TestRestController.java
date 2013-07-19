package com.bluedigm.funnylab.oauth.test.controller.rest;

import net.sf.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/rest")
public class TestRestController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getRest(){
		
		JSONObject json=new JSONObject();
		json.put("oauth_token", "oauth_token");
	    json.put("oauth_token_secret", "oauth_token_secret");
	    json.put("user_id", "user_id");
	    json.put("screen_name", "screen_name");

	    return addAttribute("application/json",json.toString());
	}
	
	public ResponseEntity<String> addAttribute(String contentType,String data){
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", contentType+"; charset=UTF-8");
		return new ResponseEntity<String>(data, responseHeaders, HttpStatus.OK);
	}
}
