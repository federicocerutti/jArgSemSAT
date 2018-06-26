
package net.sf.jargsemsatweb.jArgSemSATWeb;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/argtech")
public class ArgTechInterface {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.WILDCARD)
	public String EE(String input) throws UnsupportedEncodingException{
		
		if (!input.contains("{")){
			input = URLDecoder.decode(input, StandardCharsets.UTF_8.name());
			
			if (input.charAt(input.length()-1) == '='){
				input = input.substring(0, input.length()-1);
			}
		}
		
		Gson gs = new Gson();
		
		ArgTechData d = gs.fromJson(input, ArgTechData.class);
		
		if (d == null)
			return null;
		
		Gson gsout = new Gson();
		ArgTechOutput res = d.BL();
		
		if (res == null)
			return "";
		else
			return gsout.toJson(res);
		
	}
}
