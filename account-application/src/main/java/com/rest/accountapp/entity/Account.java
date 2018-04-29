package com.rest.accountapp.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Account implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	/**
	 * Account type e.g. Savings, Current, Loan
	 */
	@NotEmpty(message = "Account type can not be empty.")
	@Size(min=2, max=20, message = "Account type must be between 2 to 15 characters.")
	private String type;

	/**
	 * Account number
	 */
	@NotEmpty(message = "Account number can not be empty.")
	private String accountNumber;

	/**
	 * Account Description
	 */
	@NotEmpty(message = "Account Description can not be empty.")
	@Size(min=2, max=50, message = "Account Description must be between 2 to 50 characters.")
	private String description;

	/**
	 * User Id. There must be a user associated with the account
	 */
	@Min(value = 1, message="User Id must be above 0")
	private Long userId;
    
    public Account() {
    	
    }

	public Account(Long id, String type, String accountNumber, String description, Long userId) {
		this.id = id;
		this.type = type;
		this.accountNumber = accountNumber;
		this.description = description;
		this.userId = userId;
	}

	public Account(String type, String accountNumber, String description, Long userId) {
		this.type = type;
		this.accountNumber = accountNumber;
		this.description = description;
		this.userId = userId;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", accountNumber=" + accountNumber + ", description="
				+ description + ", userId=" + userId + "]";
	}		
}
