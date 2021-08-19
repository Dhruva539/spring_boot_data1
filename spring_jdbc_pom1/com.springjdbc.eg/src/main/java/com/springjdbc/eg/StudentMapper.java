package com.springjdbc.eg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
   //@Override
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      
      //Below is mapping between each column and data member
      student.setId(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setAge(rs.getInt("age"));
      student.setPhnNo(rs.getInt("phnNo"));
      student.setAddr(rs.getString("addr"));
      return student;
   }
}