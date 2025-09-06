package in.venuit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CourseMaterial {

	@Id
	@SequenceGenerator(
			name="coursematerial_sequence",
			sequenceName="coursematerial_sequence",
			allocationSize=1
			)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="coursematerial_sequence")
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY
			)
	@JoinColumn(
			name="course_id",
			referencedColumnName="courseId"
			
			)
	
	private Course course;

	public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
	
}
