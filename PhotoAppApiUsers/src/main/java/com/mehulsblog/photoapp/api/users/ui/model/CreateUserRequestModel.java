package com.mehulsblog.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotEmpty(message = "First name can not be null or empty.")
	@Size(min = 3, message = "First name must not be less then two char")
	@Size(max = 20, message = "First name must not be more then twenty char")
	private String firstName;

	@NotEmpty(message = "Last name can not be null or empty.")
	@Size(min = 3, message = "Last name must not be less then two char")
	@Size(max = 20, message = "Last name must not be more then twenty char")
	private String lastName;

	@NotEmpty(message = "Password name can not be null or empty.")
	@Size(max = 20, message = "Last name must not be more then twenty char")
	private String password;

	@NotNull(message = "Email can not be null.")
	@Email
	private String email;

	public CreateUserRequestModel() {
		super();
	}

	public CreateUserRequestModel(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CreateUserRequestModel [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + "]";
	}

}
