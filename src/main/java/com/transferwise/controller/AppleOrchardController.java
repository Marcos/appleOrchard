package com.transferwise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transferwise.AppleOrchard;

@RestController
@RequestMapping(value = "orchard")
public class AppleOrchardController {

	@Autowired
	private AppleOrchard appleOrchard;

	@RequestMapping(method = RequestMethod.GET, value = "/collect")
	public OrchardResponseDTO collectApples() {
		return new OrchardResponseDTO(appleOrchard.collectApples(Orchards.createSampleOrchard()));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/collect/token")
	public OrchardResponseDTO collectApplesWithToken() {
		return new OrchardResponseDTO(appleOrchard.collectApplesWithToken(Orchards.createSampleOrchard()));
	}

}
