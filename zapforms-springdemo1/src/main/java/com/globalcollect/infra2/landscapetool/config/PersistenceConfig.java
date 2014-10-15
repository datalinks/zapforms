package com.globalcollect.infra2.landscapetool.config;  
  
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;




@Configuration
@ComponentScan({ "com.globalcollect.infra2.landscapetool.config" })
public class PersistenceConfig {  
    
 
   
   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(getRestDataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.globalcollect.infra2.landscapetool.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
    
    @Bean
    public DataSource getRestDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/zapforms");
      dataSource.setUsername("root");
      dataSource.setPassword("ldb@3721");
//      dataSource.setPassword("");
      return dataSource;
   }
    
 

   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
  
 
 
 
 
 
   
   Properties hibernateProperties() {
      return new Properties() {
         /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
            setProperty("hibernate.hbm2ddl.auto","update");
            setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
            setProperty("hibernate.globally_quoted_identifiers", "true");
            setProperty("show_sql", "true");
            
         }
      };
   } 
    
}  
