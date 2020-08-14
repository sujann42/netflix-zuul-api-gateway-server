package com.zuuls.filter;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		
		return true; //true: it should filter everything
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "pre"; //what type of filter or when
	}

	@Override
	public int filterOrder() {
		
		return 1; //priority
	}

}
