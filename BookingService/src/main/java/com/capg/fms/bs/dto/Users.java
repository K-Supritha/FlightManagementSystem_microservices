package com.capg.fms.bs.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Users 
{
    @Id
    @Size(min=4,max=20,message="username should be 4 to 20 characters")
    private String username;
    @NotNull
    @Size(min=3,max=15,message="password should be 3 to 10 characters")
    private String password;
    @NotNull
    @Column(length=20)
    private String name;
    @NotNull
    @Column(length=10)
    private char gender;
    @NotNull
    @Column(length=35)
    @Email(message="Enter Proper Email Id")
    private String email;
    @NotNull
    @Column(length=10)
    private long phone;
    
    public Users() { }
	public Users(String username, String password, String name, char gender, String email, long phone) 
	{
		this.username = username;	this.password = password;		this.name = name;
		this.gender = gender;		this.email = email;		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
