package by.grsu.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class Registration {
	
	@Id
	@GeneratedValue
	@Column(name = "registration_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "date_fk")
	private RegisterDate date;
	
	@Column(name="user_email")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegisterDate getDate() {
		return date;
	}

	public void setDate(RegisterDate date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
