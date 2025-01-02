package Hibernate.EmployeeManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;
    
    @Column(name = "manager_id",nullable=false)
    @NotNull(message="manager id should not be null")
    @Size(min=4,max=4)
    private String manager_id;
    
    @Column(name = "name",length=20,nullable=false)
    @NotNull(message="name should not be null")
    private String name;
    
    @Column(name = "budget",nullable=false)
    @NotNull(message="enter the budget")
    private Double budget;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Department(int dept_id, String manager_id, String name, Double budget) {
		super();
		this.dept_id = dept_id;
		this.manager_id = manager_id;
		this.name = name;
		this.budget = budget;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", manager_id=" + manager_id + ", name=" + name + ", budget=" + budget
				+ "]";
	}

}