//package com.lovely.config;
//
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.lovely.shiro.UserRealm;
//
//@Configuration
//public class ShiroConfiguration {
//	private static final Logger logger=LoggerFactory.getLogger(ShiroConfiguration.class);
//	
//	
//	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
//		logger.info("注入Shiro的web过滤器-->shiroFilter",ShiroFilterFactoryBean.class);
//		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//		//Shiro的核心接口
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		//要求登录时的连接，默认会自动寻找web工程根目录下的/login.jsp
//		shiroFilterFactoryBean.setLoginUrl("/login");
//		//登录成功后要跳转的连接
//		shiroFilterFactoryBean.setSuccessUrl("/index");
//		//用户访问未对齐授权的资源时
//		shiroFilterFactoryBean.setUnauthorizedUrl("/pages/403");
//		
//		/*
//		 * 定义shiro过滤链 Map结构 
//		 * anon：所有url都都可以匿名访问
//		 * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
//		*/
//		Map<String, String> filterChainDefinitionMap=new LinkedHashMap<String,String>();
//		filterChainDefinitionMap.put("/login", "anon");
//		filterChainDefinitionMap.put("/register", "anon");
//		filterChainDefinitionMap.put("/api/**", "anon");
//		filterChainDefinitionMap.put("/**", "authc");
//		
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//		
//		return shiroFilterFactoryBean;
//	}
//	
//	@Bean
//	public SecurityManager securityManager(UserRealm userRealm){
//		logger.info("注入Shiro的Web过滤器-->securityManager",ShiroFilterFactoryBean.class);
//		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//		securityManager.setRealm(userRealm);
//		return securityManager;
//	}
//}
