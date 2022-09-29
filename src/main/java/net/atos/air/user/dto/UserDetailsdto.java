package net.atos.air.user.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.atos.air.user.validate.BirthDate;
import net.atos.air.user.validate.ResidenceCountry;

public class UserDetailsdto {
	@NotNull(message = "UserName should not be null")
	private String userName;
	@ResidenceCountry(message = " User must be french adult")
	private String residenceCountry;
	@NotNull(message = "The date of birth is required.")
	@BirthDate(message = "The registered user must be greater than 18 years")
	private Date birthdate;
	@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
	private String phoneNumber;
	private String gender;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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
}
