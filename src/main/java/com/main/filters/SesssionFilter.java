package com.main.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.app.constants.ApplicationConstants;
import com.main.service.RoleFunctionService;
import com.main.vo.LoginVO;

@WebFilter(urlPatterns="/*")
public class SesssionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Autowired
	RoleFunctionService roleFunctionService ;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		
		
		if(httprequest.getRequestURI().contains("login") 
				|| httprequest.getRequestURI().contains("logout")
				|| httprequest.getRequestURI().contains("profile")
				|| httprequest.getRequestURI().contains("getProfileImage")
				||httprequest.getRequestURI().contains("search")
				||httprequest.getRequestURI().contains("gethash")
				||httprequest.getRequestURI().contains("states")
				||httprequest.getRequestURI().contains("religions")){
			chain.doFilter(httprequest, response);
			return;
		}
		
		if(httprequest.getSession().getAttribute(ApplicationConstants.USER_INFO)!=null){
			chain.doFilter(httprequest, response);
		}else if(null==httprequest.getPathInfo()){
			chain.doFilter(httprequest, response);
		}
		else{
			httpresponse.sendRedirect("/");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
