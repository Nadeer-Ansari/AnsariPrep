
public class Employee {
	//Employee No, Name, Basic Salary
	private int empNo;
	private String name;
	private float basicSalary;
	/*All the variables are declared as 'private' and hence
	 * they are inaccessible from outside this class directly.
	*/
	
	
	
	//Method to assign values
	public void assignValues(int eno, String nm, float bs) {
		empNo = eno;
		name = nm;
		basicSalary = bs;
	}
	
	public Employee(int empNo, String name, float basicSalary) {
		this.empNo = empNo;
		this.name = name;
		this.basicSalary = basicSalary;
	}

	public Employee() {
		
	}
	public void assignValues(String nm, float bs, int eno) {
		empNo = eno;
		name = nm;
		basicSalary = bs;
	}
	public void assignValues(int eno, String nm) {
		empNo = eno;
		name = nm;		
	}
	public void assignValues(String nm, float bs) {
		name = nm;
		basicSalary = bs;
	}
	
	//Method to retrieve values in the form of String
	public String getValues() {
		String empInfo = "Employee No: " + empNo 
				+ "\nName: " + name + 
				"\nBasic Salary: " + basicSalary;
		return empInfo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
}




