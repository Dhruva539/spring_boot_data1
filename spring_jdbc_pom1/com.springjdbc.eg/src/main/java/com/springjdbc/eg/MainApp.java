/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springjdbc.eg;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");

      StudentJDBCTemplate studentJDBCTemplate = 
      (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
      List<Student> students = studentJDBCTemplate.listStudents();
      
      int i = 1;
      for (Student record : students) {
         System.out.print(i+"  ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.print(", Age : " + record.getAge());
         System.out.print(", Phn No : " + record.getPhnNo());
         System.out.println(", Addr : " + record.getAddr());
         i++;
      }
   }
}