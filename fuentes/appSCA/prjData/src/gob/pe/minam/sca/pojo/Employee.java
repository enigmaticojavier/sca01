package gob.pe.minam.sca.pojo;

import java.io.Serializable;

public class Employee implements Serializable {
	private Integer employeeId;

	private Integer age;

	private String firstName;

	private String lastName;

	public Employee() {
	}

	public Employee(Integer employeeId, String firstName, String lastName,
			Integer age ) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
}
