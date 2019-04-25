package com.portal.core.model;

import org.springframework.stereotype.Component;

@Component
public class GreetingModel {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
