package com.kln.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "residents")
public class ResidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int residentId;

    @Column(nullable = false)
    private String name;
    
    @Column(unique = true,nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String block;
    
    @Column(nullable = false,unique = true)
    private String flatNo;

    @Column(unique = true, nullable = false)
    private String mobileNo;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

	public ResidentEntity(String name, String userName, String block, String flatNo, String mobileNo, String email,
			String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.block = block;
		this.flatNo = flatNo;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	public ResidentEntity() {
		super();
	}

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "ResidentEntity [residentId=" + residentId + ", name=" + name + ", userName=" + userName + ", block="
				+ block + ", flatNo=" + flatNo + ", mobileNo=" + mobileNo + ", email=" + email + ", password="
				+ password + "]";
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
    
}