package com.clc.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.clc.*"})
@PropertySource("classpath:db.properties")
public class SpConfig {

	
	@Value("${spring.hibernate.sql.url}")
	String SQL_URL;
	
	@Value("${spring.hibernate.sql.driver}")
	String SQL_DRIVER;
	
	@Value("${spring.hibernate.sql.username}")
	String SQL_USERNAME;
	
	
	@Value("${spring.hibernate.sql.password}")
	String SQL_PASWORD;
	
	@Value("${spring.hibernate.sql.dialect}")
	String SQL_DIALECT;
	
	@Value("${spring.hibernate.sql.createtable}")
	String SQL_CREATE_TABLE;
	
	@Value("${spring.hibernate.sql.showsql}")
	String SQL_SHOW;
	
	@Value("${spring.hibernate.sql.format}")
	String SQL_FORMAT;
	
	@Value("${spring.hibernate.sql.scn.pkg}")
	String SQL_SCAN_PACKAGE;
	
	@Bean
	public BasicDataSource getbasiBasicDataSource() {
		
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(SQL_URL);
		bds.setUsername(SQL_USERNAME);
		bds.setPassword(SQL_PASWORD);
		bds.setDriverClassName(SQL_DRIVER);
		return bds;
	}
	
	@Bean
	public LocalSessionFactoryBean getCurrentFactoryBean() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getbasiBasicDataSource());
		lsfb.setPackagesToScan(SQL_SCAN_PACKAGE);
		lsfb.setHibernateProperties(gethibernateProperties());
		return lsfb;
	}

	private Properties gethibernateProperties() {
		Properties prop = new Properties();
		prop.put(Environment.DIALECT,SQL_DIALECT);
		prop.put(Environment.SHOW_SQL,SQL_SHOW);
		//prop.put("hbm2ddl.auto","create");
		prop.put(Environment.HBM2DDL_AUTO, SQL_CREATE_TABLE);
		//prop.put(Environment.FORMAT_SQL,SQL_FORMAT);
		return prop;
	}
	
	@Bean
	public InternalResourceViewResolver prepareViewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/");
		view.setSuffix(".jsp");
		return view;
	}
	
}
