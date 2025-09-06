import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {

	public Student(int id, String sname) {
		super();
		this.id = id;
		this.sname = sname;
	}

	private int id;
	private String sname;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set=new HashSet<>();
		String s1=new String("venu");
		String s2=new String("venu");
		Student st1=new Student(10,"syam");
		Student st2=new Student(10,"syam");
		set.add(st2);
		set.add(st1);
		System.out.println(st2.equals(st1));
		System.out.println(set);
	}

	public boolean equals(Object o)
	{
		if(this==o)
		{
			return true;
		}
		if(o==null ||getClass()!=o.getClass())
			return false;
		Student other=(Student)o;
		if(this.id!=other.id)
		{
			return false;
		}
		if(this.sname ==null)
		{
			return other.sname==null;
		}else
		{
			return this.sname.equals(other.sname);
		}
		
	}
	
	public int hashCode()
	{
		int result=17;
		result=31*result+id;
		result=31*result+(sname!=null ? sname.hashCode():0);
		return result;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
