package com.sinbugs.rest.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ApiService {
    
	public String api_retorna() throws MalformedURLException, IOException {
		String jsonText;
		String jsonTex2 = "";
		String[] parts;
		String resultado = "";
		InputStream is = new URL("https://jsonplaceholder.typicode.com/comments").openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      jsonText = readAll(rd);
	      parts = jsonText.split("},");
	      for (int i = 0; i < parts.length; i++){
	    	  if( i == 0) {
	    		  jsonTex2 =parts[0].replace(",", "|").replace("[","");
	    		  jsonTex2 = jsonTex2.replace(",", "");
	    		  jsonTex2 = jsonTex2.replace("{", "{ data: [");
	    	  }
	    	  else
	    	  {
	    		  jsonTex2 =jsonTex2+parts[i].replace(",", "|").replace("{", ",");
	    	  }
	    	  
	      }
	      
	      
	    } finally {
	      is.close();
	    }
	    resultado = jsonTex2.replace("}", "");	 
	    resultado = resultado.replace("]", "");	 
	    return resultado+"] }";
	}
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	}
}
