package jcg.zheng.demo.app;

import javax.xml.ws.Endpoint;

import jcg.zheng.demo.service.impl.HelloWorldServiceImpl;

/**
 * see http://localhost:9980/helloworld?wsdl
 *
 * should be tested by SOAP UI
 */
public class ServerApp {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9980/helloworld", new HelloWorldServiceImpl());
		System.out.println("HelloworldServices Started!");
	}
}