package in.venuit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.venuit.entity.Student;
import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

	public List<Student> findByFirstName(String firstname);
	
	public Student findByEmailId(String email);
	
	
	//NativeQueryByNamed
	
	@Query(value="select * from tbl_student s where s.email_address=:emailId",nativeQuery=true)
	Student getStudentByEmailAddressNativeNamed(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(value="update tbl_student set first_name=?1 where email_address=?2",nativeQuery=true)
	int updateStudentNameByEmailId(Student student);

	
}
