package net.atos.Codex_IOT.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author A666395 This is for database configuratione
 *
 */
@Configuration
@EnableTransactionManagement
@Profile("dev")
public class DatabaseConfig {
	private static final Logger logger = Logger.getLogger(DatabaseConfig.class);

	private String url;
	
	@Autowired
	private Environment env;
	
	
	@Value("${entitymanager.packagesToScan}")
	private String packageToScan;

	/**
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
		
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
		this.url="jdbc:postgresql://"+ env.getProperty("spring.datasource.host") + ":"
				+ env.getProperty("spring.datasource.port") + "/"+ env.getProperty("spring.datasource.dbname");
		System.out.println("url :"+url);
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setDriverClassName(env
				.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(this.url);
		return dataSource;*/
	}

	/**
	 * @return LocalSessionFactoryBean
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	/**
	 * @return transactionManager
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}