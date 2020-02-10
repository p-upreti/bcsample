package com.pupreti.bcrestapp.controller;

import com.pupreti.bcrestapp.model.AuthorizationRequest;
import com.pupreti.bcrestapp.service.IEntitlementMgr;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

	@Autowired
	private IEntitlementMgr entitlementMgr;


	@RequestMapping("/")
	public String index() {
		return "Security is fun believe it or not!!!";
	}

	@PostMapping("/users/{userId}/authorize")
	public ResponseEntity<?> authorize(@RequestBody AuthorizationRequest authRequest, @PathVariable String userId) {
		Boolean hasAccess = entitlementMgr.validateEntitlementAccess(userId, authRequest);

		if(hasAccess) {
			return new ResponseEntity<>("Authorized", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
		}
	}

}
