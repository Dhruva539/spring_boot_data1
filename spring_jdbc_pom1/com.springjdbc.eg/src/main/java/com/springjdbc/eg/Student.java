/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springjdbc.eg;

public class Student {
   private Integer age;
   private String name;
   private Integer id;
   private Integer phnNo;
   private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
   
   public void setAge(Integer age) {
      this.age = age;
   }
   public Integer getAge() {
      return age;
   }

   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   public void setId(Integer id) {
      this.id = id;
   }
   public Integer getId() {
      return id;
   }

    /**
     * @return the phnNo
     */
    public Integer getPhnNo() {
        return phnNo;
    }

    /**
     * @param phnNo the phnNo to set
     */
    public void setPhnNo(Integer phnNo) {
        this.phnNo = phnNo;
    }
}


