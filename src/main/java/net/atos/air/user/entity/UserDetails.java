package net.atos.air.user.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
@Entity
  
public class UserDetails {
	
//mark id as primary key  
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//defining id as column name  
	@Column  
	private int id;  
	//defining name as column name  
	@Column  
	private String userName;  
	//defining age as column name  
	@Column  
	private Date birthdate;  
	//defining email as column name  
	@Column  
	private String residenceCountry;  
	
	@Column
	private String phoneNumber;
	
	@Column
	private String gender;

	public int getId()   
	{  
	return id;  
	}  
	public void setId(int id)   
	{  
	this.id = id;  
	}  

	
	
	
public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getResidenceCountry() {
		return residenceCountry;
	}
	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
public UserDetails() {
		
	}
	
}
