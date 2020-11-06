package com.mmi.ismatul.employee.services;

import com.mmi.ismatul.employee.entity.Employee;
import com.mmi.ismatul.employee.entity.Position;
import com.mmi.ismatul.employee.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceDBImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public Position savePosition(Position position) {
        if (position.getId()==null){
            position.setRemove(false);
        }
        return positionRepository.save(position);
    }

    @Override
    public Position getPositionById(Integer id) {
        Position position = null;
        if (positionRepository.findById(id).isPresent())
            position = positionRepository.findById(id).get();
        return position;
    }

    @Override
    public Page<Position> getPositions(Pageable pageable) {
        return positionRepository.findAllByRemoveIsFalse(pageable);
    }

    @Override
    public void deletePosition(Integer id) {
        Position position = getPositionById(id);
        position.setRemove(true);
        positionRepository.save(position);
    }

}
