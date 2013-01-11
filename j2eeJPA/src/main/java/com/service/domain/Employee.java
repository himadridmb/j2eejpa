package com.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String firstName;
	private String surname;
	private int salary;
	
	public Employee()
	{
		// required by JPA
	}
	
	public Employee(String firstName, String surname, int salary)
	{
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.salary = salary;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstName=" + firstName + ", surname="
				+ surname + ", salary=" + salary + "]";
	}
	
	
}
