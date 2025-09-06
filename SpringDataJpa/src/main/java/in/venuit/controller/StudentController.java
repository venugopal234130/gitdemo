package in.venuit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.venuit.entity.Student;
import in.venuit.exception.StudentNotFoundException;
import in.venuit.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}
	
	@GetMapping("/retrive")
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> student=studentService.getAllStudents();
		if(student.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/retrive/{id}")
	public ResponseEntity<Optional<Student>>  getStudentById(@PathVariable Long id)
	{
		Optional<Student> student1=studentService.getStudentsById(id);
		if(!student1.isPresent())
		{
			StudentNotFoundException st=new StudentNotFoundException(id);
			throw st;
		}
		return ResponseEntity.ok(student1);
	}
	
	
	
	@GetMapping("/retrive/first/{firstname}")
	public ResponseEntity<List<Student>>  getStudentByFName(@PathVariable String firstname)
	{
		List<Student> students=studentService.getStudentsByFirstName(firstname);
		if(students.isEmpty())
		{
			StudentNotFoundException st=new StudentNotFoundException(firstname);
			throw st;
		}
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/retrive/second/{emailId}")
	public ResponseEntity<Student> getStudentByEmail(@PathVariable String emailId)
	{
			Student student=studentService.getStudentByEmail(emailId);
			if(student==null)
			{
				StudentNotFoundException st=new StudentNotFoundException(emailId);
				throw st;
			}
			return ResponseEntity.ok(student);
	}
	
	//@PutMapping("/update")
/*	public int updateStudentbyEmail(@RequestBody Student student)
	{
		studentService.updateStudentByEmail(student);
		if(student==null)
		{
			StudentNotFoundException st=new StudentNotFoundException(student.getEmailId());
			throw st;
		}
		return 1;
	} */
	
}
