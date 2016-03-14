package io.egen.apollo;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:app.properties")
public class JPAConfig extends WebMvcConfigurerAdapter{
	@Autowired
	public Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[]{"io.egen.apollo.entity"});
		JpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(jpaVendor);
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	
	private Properties jpaProperties () {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show.sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
		properties.put("hibernate.enable_lazy_load_no_trans",env.getProperty("hibernate.enable_lazy_load_no_trans"));
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager (EntityManagerFactory emf) {
		JpaTransactionManager txnManager = new JpaTransactionManager(emf);
		return txnManager;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername(env.getProperty("db.user"));
                String password = env.getProperty("db.password");
                if(password != null && !password.isEmpty()) ds.setPassword(password);
		ds.setUrl(env.getProperty("db.url"));
		
		return ds;
	}
}
