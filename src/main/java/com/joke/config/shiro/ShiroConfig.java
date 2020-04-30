package com.joke.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author dongyin
 */
@Configuration
public class ShiroConfig {

	static final String MD5 = "MD5";

	static final int HASHITERATIONS = 108;

	static final String DEV = "dev";

//	@Value("${spring.profiles.active}")
//	private String PROFILE;
//
//	@Value("${swagger2.enable}")
//	public String Swagger;

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//Shiro的核心安全接口,这个属性是必须的
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, Filter> filterMap = new LinkedHashMap<>();
		filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
		shiroFilterFactoryBean.setFilters(filterMap);
		/*定义shiro过滤链  Map结构
		 * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
		 * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种DrugExaminationItems
		 * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
		 */
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
         /* 过滤链定义，从上向下顺序执行，一般将 / ** 放在最为下边:这是一个坑呢，一不小心代码就不好使了;
          authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 */

		filterChainDefinitionMap.put("/swagger-resources", "anon");
		filterChainDefinitionMap.put("/v2/**", "anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/doc.html", "anon");
		filterChainDefinitionMap.put("/userInfo/login", "anon");
		filterChainDefinitionMap.put("/**", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * ）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法  MD5
		hashedCredentialsMatcher.setHashAlgorithmName(MD5);
        //散列次数
		hashedCredentialsMatcher.setHashIterations(HASHITERATIONS);
		return hashedCredentialsMatcher;
	}

	@Bean
	public ShiroRealm myShiroRealm(){
		ShiroRealm shiroRealm = new ShiroRealm();
		shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return shiroRealm;
	}


	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setSessionManager(sessionManager());
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}

	/**
	 * Shiro生命周期处理器
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 */
	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * cookie对象;
	 * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie(){
		//这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		//<!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}

	/**
	 * cookie管理对象;
	 * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager(){
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		return cookieRememberMeManager;
	}

	@Bean
	public SessionManager sessionManager() {
		return new CustomSessionManager();
	}
}
