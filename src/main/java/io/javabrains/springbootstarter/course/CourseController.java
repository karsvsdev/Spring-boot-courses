package io.javabrains.springbootstarter.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.Controller;

import io.javabrains.springbootstarter.topic.Topic;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{id}/courses")
	public List<Course>getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
				
				
	}
	
	
	@GetMapping("/topics/{topicId}/courses/{id}")
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
