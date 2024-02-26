package com.authorization.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class Server {
	
	@GetMapping("/get")
	public void get() {
		System.out.println("server started..");
	}

}
