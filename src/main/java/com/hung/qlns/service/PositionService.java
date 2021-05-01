package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.Position;
import com.hung.qlns.repository.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository poRepository;
	
	public List<Position> allPosition(){
		 return poRepository.findAll();
	}
	public Optional<Position> getPosition(Long posId) {
		return poRepository.findById(posId);
	}
	
	public Position createPosition(Position position) {
		poRepository.save(position);
		return position;
	}
	
	public Boolean isValid(Long posId) {
		Optional<Position> pos = poRepository.findById(posId);
		return pos.isPresent();
	}
	
	public Position updatePosition(Position position, Long posId) {
		Optional<Position> pos = poRepository.findById(posId);
			Position newPos = pos.get();
			newPos.setPosName(position.getPosName());
			newPos.setPosCode(position.getPosCode());
			newPos.setPosDesc(position.getPosDesc());
			poRepository.save(newPos);
			return newPos;
	}
	
	public Long deletePosition(Long posId) {
		poRepository.deleteById(posId);		
		return posId;
	}

}
