package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class HelloWorldController   
{  
@RequestMapping("/")  
public String hello()   
{  
return "Hello Vishwa V How are You";  
}  	
@RequestMapping("/add")
public int add()
{
	int a=34;
	int b=3;
	int c=a+b;
	return c;
}
@RequestMapping("/greet")
public String greet()
{
	String name="john";
	return "Hi Welcome "+name;
}
}  