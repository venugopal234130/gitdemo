import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
public class Employee {
	private int id;
	private String ename;
	private int salary;
	public Employee(int id, String ename, int salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee(1,"venu",105);
		Employee e2=new Employee(2,"gopal",205);
		Employee e3=new Employee(3,"vamsi",305);
		List<Employee> list=Arrays.asList(e1,e2,e3);
		List<String> names=list.stream().map(Employee::getEname).filter(name->name.startsWith("v")).collect(Collectors.toList());
	System.out.println("Sample Commite addded to check");
	}
	
	
	
	}


