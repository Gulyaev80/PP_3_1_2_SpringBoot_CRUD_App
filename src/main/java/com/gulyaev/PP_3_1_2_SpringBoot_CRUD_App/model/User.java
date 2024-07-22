package com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.model;




import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @jakarta.persistence.Id
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	@NotEmpty(message = "Name should not be empty")
	@Size(min = 3, max = 30, message = "Name should be between 2 and 30 chars")
	private String name;

	@Column(name = "surname")
	@NotEmpty(message = "Name should not be empty")
	@Size(min = 3, max = 30, message = "Name should be between 2 and 30 chars")
	private String surname;

	@Column(name = "email")
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Name should not be empty")
	private String email;

	@Column(name = "age")
	@Min(value = 0, message = "Age should be greater than 0")
	private int age;

	public User() {
	}

	public User(int id, String name, String surname, String email, int age) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, surname, email, age);
	}


}
