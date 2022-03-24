package com.student.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;



@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties( allowGetters = true)
public class Student  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;  
	private Long student_age;  
	private String student_phno_number;  
	private String address;  
	private String student_name;  
    private String student_email;  
    private String student_branch;
	
	
	public Long getStudent_age() {
		return student_age;
	}
	public void setStudent_age(Long student_age) {
		this.student_age = student_age;
	}
	public String getStudent_phno_number() {
		return student_phno_number;
	}
	public void setStudent_phno_number(String student_phno_number) {
		this.student_phno_number = student_phno_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

    
    public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
 
    
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_branch() {
		return student_branch;
	}
	public void setStudent_branch(String student_branch) {
		this.student_branch = student_branch;
	}
	
}
