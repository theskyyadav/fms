package com.pjsoft.fms.pojo.request;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class PassengerDTO {
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    @NotNull(message = "First name is required")
	    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
	    private String firstName;

	    @Column(nullable = false)
	    @NotNull(message = "Last name is required")
	    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
	    private String lastName;

	    @Column(nullable = false)
	    @Email(message = "Email should be valid")
	    @NotNull(message = "Email is required")
	    private String email;

	    @Column(nullable = false)
	    private String phone;
	    
	    @Column(nullable = false)
	    @NotNull(message = "Date of birth is required")
	    @Past(message = "Date of birth must be in the past")
	    private LocalDate dateOfBirth;
		
		 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}


	}
