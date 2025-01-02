package Hibernate.EmployeeManagement.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;
    
    @Column(name = "first_name",length=20,nullable=false)
    @NotNull(message="Enter the name")
    @Size(min=2,max=20)
    private String first_name;
    
    @Column(name = "last_name",length=20,nullable=false)
    @NotNull(message="Enter the last name")
    @Size(min=4,max=20)
    private String last_name;
    
    @Column(name="email",length=30,nullable=false,unique=true)
    @NotNull(message="Email is required")
    @Email(message="Email should be valid")
    private String email;
    
    @Column(name="phone",length=30,nullable=false,unique=true)
    @NotNull(message="Phone number is required")
    @Pattern(regexp="[6789]{1}[0-9]{9}",message="Enter proper phone number")
    private String phone;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public Employee(int empid, String first_name, String last_name, String email, String phone) {
		super();
		this.empid = empid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", phone=" + phone + "]";
	}

}