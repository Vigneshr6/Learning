package com.vignesh.springboot_playground.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	private final String status = "failed";
	List<String> errors = new ArrayList<>();
}
