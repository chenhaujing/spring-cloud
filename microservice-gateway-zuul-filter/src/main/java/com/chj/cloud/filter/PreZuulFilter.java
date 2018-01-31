package com.chj.cloud.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter extends ZuulFilter {
	
	private static final String SERVICE_ID_KEY = "microservice-provider-user";
	
	
	//是否拦截过滤
	@Override
	public boolean shouldFilter() {
//		RequestContext ctx = RequestContext.getCurrentContext();
		return true;
	}
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
		String host = request.getRemoteHost();
		System.out.println("请求的host："+host);
		if (request.getParameter("microservice-provider-user") != null) {
		    // put the serviceId in `RequestContext`
    		ctx.put(SERVICE_ID_KEY, request.getParameter("microservice-provider-user"));
    	}
        return null;
    }
    
	@Override
	public int filterOrder() {
		return 0; // run before PreDecoration
	}

	@Override
	public String filterType() {
		return "pre";
	}


}
