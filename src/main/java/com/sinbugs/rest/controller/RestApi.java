package com.sinbugs.rest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinbugs.rest.service.ApiService;

@RestController
public class RestApi {
	
	private final ApiService restService;
	public RestApi(ApiService restService) {
		// TODO Auto-generated constructor stub
		this.restService = restService;
	}
	@Test
	@RequestMapping(value="/api", method=RequestMethod.GET)
	public ResponseEntity retorna_api() throws MalformedURLException, IOException{
		return  ResponseEntity.ok(restService.api_retorna());
		
	}
	
}
