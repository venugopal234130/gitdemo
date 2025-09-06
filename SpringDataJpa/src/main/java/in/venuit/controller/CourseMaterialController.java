package in.venuit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.venuit.entity.CourseMaterial;
import in.venuit.repository.CourseMaterialRepository;

@RestController
@RequestMapping("/course")
public class CourseMaterialController {

	@Autowired
	private  CourseMaterialRepository courseMaterialRepository;
	
	@PostMapping("/create")
	public ResponseEntity<CourseMaterial> saveCourseMaterial(@RequestBody CourseMaterial courseMaterial)
	{
		
		CourseMaterial saved=courseMaterialRepository.save(courseMaterial);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
}
