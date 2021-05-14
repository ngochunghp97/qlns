package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.dto.PositionDTO;
import com.hung.qlns.model.Employee;
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
	
	public Position createPosition(PositionDTO positionInput) {
		Position position = new Position();
		position.setPosName(positionInput.getPosName());
		position.setPosCode(positionInput.getPosCode());
		position.setPosDesc(positionInput.getPosDesc());
		poRepository.save(position);
		return position;
	}
	
	public Boolean isValid(Long posId) {
		Optional<Position> pos = poRepository.findById(posId);
		return pos.isPresent();
	}
	
	public Position updatePosition(Long posId, PositionDTO positionInput) {
		Optional<Position> pos = poRepository.findById(posId);
			if(pos.isPresent()) {
				Position newPos = pos.get();
				newPos.setPosName(positionInput.getPosName());
				newPos.setPosCode(positionInput.getPosCode());
				newPos.setPosDesc(positionInput.getPosDesc());
				poRepository.save(newPos);
				return newPos;
			}else {
				return null;
			}
			
	}
	
	public boolean deletePosition(Long posId) {
		Optional<Position> po = poRepository.findById(posId);
		if(po.isPresent()) {
			Position p = po.get();
			poRepository.delete(p);
			return true;
		}else {
			return false;
		}
	}

}
