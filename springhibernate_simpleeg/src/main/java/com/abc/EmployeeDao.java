/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this eTemplate file, choose Tools | Templates
 * and open the eTemplate in the editor.
 */
package com.abc;

/**
 *
 * @author ADMIN
 */
import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDao {
HibernateTemplate eTemplate;
public void seteTemplate(HibernateTemplate eTemplate) {
	this.eTemplate = eTemplate;
}

@Transactional(readOnly=false)
public void saveEmployee(Employee e){
	eTemplate.save(e);
}

@Transactional(readOnly=false)
public void updateEmployee(Employee e){
	eTemplate.update(e);
}

@Transactional(readOnly=false)
public void deleteEmployee(Employee e){
	eTemplate.delete(e);
}

@Transactional(readOnly=false)
public List<?> queryEmployee(){
	List<?> el = eTemplate.find("FROM Employee");
        return el;
}
}
