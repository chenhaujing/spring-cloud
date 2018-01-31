package com.chj.cloud.filter;

import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ZuulRouterFilter extends ZuulFilter {
	
	private static final String POST_TYPE = "post";
	private static final int SEND_RESPONSE_FILTER_ORDER = 1;
	
	
	@Override
	public String filterType() {
		return POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
    	HttpServletResponse servletResponse = context.getResponse();
		servletResponse.addHeader("X-microservice-provider-user", UUID.randomUUID().toString());
		return null;
	}
}
