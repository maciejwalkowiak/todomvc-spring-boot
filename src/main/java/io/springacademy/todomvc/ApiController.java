package io.springacademy.todomvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class ApiController {

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<Void> api() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
