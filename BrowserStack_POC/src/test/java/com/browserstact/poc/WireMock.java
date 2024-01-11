package com.browserstact.poc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;



public class WireMock {
	
	public WireMockServer wireMockServer;
	String host = "localhost";
	int port = 8080;
	String proxyBaseUrl= "http://google.com";
	
	
	@BeforeTest
	public void setup()
	{
		wireMockServer = new WireMockServer();
		configureFor(host, port);
		wireMockServer.start();
		System.out.println("WireMock server has started");
		
		
		stubFor(any(anyUrl()).willReturn(aResponse().proxiedFrom(proxyBaseUrl)));
	}
	
	@Test()
	public void tc_001()
	{
		
		System.out.println("Inside TC_001");
		
	}
	
	@AfterMethod
	public void teardown() 
	{
		wireMockServer.stop();
		System.out.println("WireMock server has stopped");
	}

}
