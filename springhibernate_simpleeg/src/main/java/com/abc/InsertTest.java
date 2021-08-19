/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

/**
 *
 * @author ADMIN
 */
import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class InsertTest {
public static void main(String[] args) {
	
	//Resource r=new ClassPathResource("applicationContext.xml");
	//BeanFactory factory=new XmlBeanFactory(r);

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	EmployeeDao dao=(EmployeeDao)context.getBean("d");
	
	Employee e=new Employee();
	e.setId(251);
	e.setName("Kishore");
	e.setSalary(8011000);
	
	dao.saveEmployee(e);
	//dao.updateEmployee(e);
        
        List<?> empl = dao.queryEmployee();
        
        for(Object eobj:empl)
        {
            Employee etmp = (Employee)eobj;
            
            System.out.println(etmp.getName()+" "+etmp.getSalary());
        }
}
}
