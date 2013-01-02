package com.service.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Family {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int familyid;
  private String description;

  public Family()
  {}
  
  @OneToMany(mappedBy="family")
  private  List<Person> members = new ArrayList<Person>();

 

  public int getFamilyid() {
	return familyid;
}

public void setFamilyid(int familyid) {
	this.familyid = familyid;
}

public void setMembers(List<Person> members) {
	this.members = members;
}

public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Person> getMembers() {
    return members;
  }

} 