package Hibernate.EmployeeManagement.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Hibernate.EmployeeManagement.entity.Department;
import Hibernate.EmployeeManagement.entity.Employee;
import Hibernate.EmployeeManagement.entity.Login;
import Hibernate.EmployeeManagement.entity.Role;

public class HibernateUtil {
private static SessionFactory sessionFactory=null;
	
	
	public static SessionFactory getSessionFactory()
	{
		
		if(sessionFactory==null)
		{
		   try 
		   {
			   Configuration configuration=new Configuration();
			   
			   Properties settings=new Properties();
			   
			   settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			   settings.put(Environment.URL, "jdbc:mysql://localhost:3306/onetoonemapping");
			   settings.put(Environment.USER, "root");
			   settings.put(Environment.PASS, "shamsheeraAT");
			   settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			   settings.put(Environment.SHOW_SQL, true);
			   settings.put(Environment.FORMAT_SQL, true);
			   settings.put(Environment.HBM2DDL_AUTO, "update");
			   
			   configuration.setProperties(settings);
			   configuration.addAnnotatedClass(Role.class);

			   configuration.addAnnotatedClass(Login.class);
			   configuration.addAnnotatedClass(Department.class);
			   
			   configuration.addAnnotatedClass(Employee.class);
			 
			   
			   ServiceRegistry serviceRegistry=(ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			   
			   sessionFactory=configuration.buildSessionFactory(serviceRegistry);
			   
			   
			   
		   }
		   catch (Exception e)
		   {
			System.out.println(e);
		   }
		}
		
		return sessionFactory;
		
	}

}

