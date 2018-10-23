package com.prdx.admin.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.prdx.admin.constant.DBConstants;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig {

	private String packagesToScan = "com.prdx.admin.bean.contact";
	
	//db config
	private String dbURL = "jdbc:mysql://203.121.143.61:3306/PRDXDBA?autoReconnect=true&useSSL=false";
	private String driverClass = "com.mysql.jdbc.Driver";
	private String username = "prdxdba";
	private String password = "Prdxdba@1";
	
	private int maxPoolSize = 200;
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(prdxDataSource());
		em.setPackagesToScan(packagesToScan);
		em.setPersistenceUnitName(DBConstants.PRDX_UNIT);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean(name = "prdxDataSource")
	public DataSource prdxDataSource() throws Exception {
		HikariDataSource datasource = new HikariDataSource();
		datasource.setJdbcUrl(dbURL);
		datasource.setDriverClassName(driverClass);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.addDataSourceProperty("cachePrepStmts", true);
		datasource.addDataSourceProperty("prepStmtCacheSize", 250);
		datasource.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		datasource.addDataSourceProperty("useServerPrepStmts", true);
		datasource.setConnectionTimeout(10000L);
		datasource.setValidationTimeout(10000L);
		datasource.setMaximumPoolSize(maxPoolSize);
		datasource.setMinimumIdle(10);
		datasource.setMaxLifetime(10000L);
		datasource.setIdleTimeout(10000L);
		datasource.setConnectionTestQuery("SELECT CURRENT_TIMESTAMP");

		return datasource;
	}

	// @Bean
	// public DataSource prdxDataSource() {
	// Context ctx;
	// DataSource ds = null;
	// try {
	// ctx = new InitialContext();
	// ds = (DataSource) ctx.lookup(DBConstants.PRDX_DATASOURCE);
	// } catch (NamingException e) {
	// e.printStackTrace();
	// }
	// return ds;
	// }

	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception {
		return new JdbcTemplate(prdxDataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		// properties.setProperty("hibernate.default_schema", "edns");
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.format_sql", "false");
		properties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.setProperty("javax.persistence.validation.mode", "none");
		return properties;
	}
}