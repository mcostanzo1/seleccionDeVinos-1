package com.dp3.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException exception) throws IOException, ServletException {
		if (exception instanceof MissingCsrfTokenException || exception instanceof InvalidCsrfTokenException) {
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}
	
}
