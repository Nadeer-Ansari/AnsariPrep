package record_classes;

import java.util.Objects;

public class WithoutRecordClassesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department dept = new Department(1, "Sales");
		System.out.println(dept.getDeptNo() + " " + dept.getName());
		System.out.println(dept);
		
		Department dept2 = new Department(1, "Sales");
		System.out.println(dept.equals(dept2));
	}

}

class Department {
	private int deptNo;
	private String name;
	
	Department(int deptNo, String name){
		this.deptNo = deptNo;
		this.name = name;
	}

	int getDeptNo() {
		return deptNo;
	}

	String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptNo, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return deptNo == other.deptNo && Objects.equals(name, other.name);
	}
	
}
