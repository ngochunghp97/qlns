package com.hung.qlns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.qlns.dto.PositionDTO;
import com.hung.qlns.dto.ResponseData;
import com.hung.qlns.model.Position;
import com.hung.qlns.service.PositionService;

@RestController
@RequestMapping("/api")
public class PositionController {

	@Autowired
	private PositionService poService;

	@GetMapping("/position")
	public ResponseEntity<Position> allPosition() {
		List<Position> poList = poService.allPosition();
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), poList),HttpStatus.OK);
	}

	@GetMapping("/position/{id}")
	public ResponseEntity<Object> getPosition(@PathVariable("id") Long posId) {
		return new ResponseEntity<Object>(poService.getPosition(posId), HttpStatus.OK);
	}

	@PostMapping("/position/create")
	public ResponseEntity<Position> createPosition(@RequestBody PositionDTO positionInput) {
		Position position = poService.createPosition(positionInput);
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), position),HttpStatus.OK);
	}

	@GetMapping("/position/update/{id}")
	public ResponseEntity<Position> updatePosition(@PathVariable("id") Long posId, @RequestBody PositionDTO positionInput) {
//			Position p = poService.updatePosition(posId, positionInput);
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), poService.updatePosition(posId, positionInput)), HttpStatus.OK);
	}

	@GetMapping("/position/delete/{id}")
	public ResponseEntity<Object> deletePosition(@PathVariable("id") Long posId) {
		if (poService.isValid(posId)) {
			return new ResponseEntity<Object>(poService.deletePosition(posId), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
