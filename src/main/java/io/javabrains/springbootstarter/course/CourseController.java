package io.javabrains.springbootstarter.course;


import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value="/topics/{id}/courses", produces=MediaType.APPLICATION_JSON_VALUE )
	public List<Course>getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
				
				
	}
	
	
	@GetMapping(value="/topics/{topicId}/courses/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
		
	}

	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
		
	}
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
		
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
		
	}
	
}
