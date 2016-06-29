package org.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Service
@Path("/msg")
public class CxfService {
	@POST
	@Path("/prime")
	@Produces(MediaType.TEXT_PLAIN)
	public String display(@FormParam("number") int number) {
		String msg = null;
		int i, m = 0, flag = 0;
		int n = number;// it is the number to be checked
		m = n / 2;
		for (i = 2; i <= m; i++) {

			if (n % i == 0) {

				msg = "Number is not prime";
				flag = 1;
				break;
			}
		}

		if (flag == 0)
			msg = "Number is prime";
		
		return msg;

	}

}
