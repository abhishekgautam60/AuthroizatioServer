package com.authorization;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class UserController {
	
	@GetMapping("/user/me")
	public Principal user(Principal principal) {
		return principal;
	}

}
