package record_classes;

import java.util.Objects;
record Dept(int deptNo, String name) {}
public class WithRecordClassesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dept dept = new Dept(2, "Purchase");
		System.out.println(dept);
		
		Dept dept2 = new Dept(2, "Purchase");
		System.out.println(dept.equals(dept2));
	}

}

/*class Department {
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
	
}*/
