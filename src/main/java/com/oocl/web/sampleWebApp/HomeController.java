package com.oocl.web.sampleWebApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
    
    @RequestMapping("/hello")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String greeting1() {
        return "Hello World";
    }
  @RequestMapping("/user")
    public @ResponseBody Map MapgetName() {
    	Map user = new HashMap();
    	user.put("user","name");
    	return user;
    }
  
  @RequestMapping("/user")
  public @ResponseBody Map Mapjson() {
  	Map user = new HashMap();
  	user.put("id","001");
  	return user;
  }
}