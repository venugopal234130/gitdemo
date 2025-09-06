package in.venuit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.venuit.entity.Student;
import in.venuit.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student createStudent(Student student)
	{
		
		Student savedstudent= studentRepository.save(student);
		return savedstudent;
		
	}
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentsById(Long id)
	{
		Optional<Student> student=studentRepository.findById(id);
		return student;
		
	}
	
	public List<Student> getStudentsByFirstName(String firstname)
	{
		List<Student> students=studentRepository.findByFirstName(firstname);
		return students;
	}
	
	public Student getStudentByEmail(String email)
	{
		return studentRepository.getStudentByEmailAddressNativeNamed(email);
	}
	
	
/*	public int updateStudentByEmail(Student student)
	{
		Student x=studentRepository.updateStudentNameByEmailId(student);
		return x;
	}*/
}
