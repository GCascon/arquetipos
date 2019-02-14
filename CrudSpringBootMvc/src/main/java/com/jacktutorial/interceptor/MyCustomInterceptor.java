package com.jacktutorial.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.HandlerInterceptor;



public class MyCustomInterceptor implements HandlerInterceptor{

	private static final Logger LOGGER =
		      LoggerFactory.getLogger(MyCustomInterceptor.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
    	LOGGER.info("Dentro del interceptor :: "+request.getRequestURI());
    	
    	Object usulogado=request.getSession().getAttribute("logedUser");
    	LOGGER.info("Dentro del interceptor:: usu logado :: "+usulogado);

    	if(usulogado==null && 
    			(!request.getRequestURI().contains(".js") 
    			&& !request.getRequestURI().contains(".css")    			
    			&& !request.getRequestURI().equals("/error")
    			&& !request.getRequestURI().equals("/")
    			&& !request.getRequestURI().equals("/login"))){
    		LOGGER.error("Prohibido!!");    
    		response.sendRedirect("/error.jsp");
    		return false;
    	}else return true;
        
    }
}
