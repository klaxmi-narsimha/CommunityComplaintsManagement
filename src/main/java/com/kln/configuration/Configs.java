package com.kln.configuration;

import java.util.Properties;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import org.hibernate.SessionFactory;

@Configuration
@ComponentScan(basePackages = "com.kln")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class Configs {
	
	@Value("${DB_USERNAME}")
	String dbUsername;

	@Value("${DB_PASSWORD}")
	String dbPassword;
	
	@Value("${DB_URL}")
	String dbUrl;
	
   
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		DataSource dataSource = dataSource();
		
		sf.setDataSource(dataSource);
		sf.setPackagesToScan("com.kln");
		sf.setHibernateProperties(properties());
		return sf;
	}
	
	@Bean
	public Properties properties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}
	
	@Bean
	public DataSource dataSource() {
		
		System.out.println("*******************************************");
		
	 System.out.println(dbUsername);
			

		System.out.println("*******************************************");
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl(dbUrl);
		dmds.setUsername(dbUsername);
		dmds.setPassword(dbPassword);
		return dmds;
		
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tm = new HibernateTransactionManager(sessionFactory);
		return tm;
	}

	

	
	@Bean
	public InternalResourceViewResolver irvr() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
	
	

}
