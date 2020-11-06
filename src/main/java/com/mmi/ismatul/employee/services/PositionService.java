package com.mmi.ismatul.employee.services;

import com.mmi.ismatul.employee.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService {
    public Position savePosition(Position position);
    public Position getPositionById(Integer id);
    public Page<Position> getPositions(Pageable pageable);
    public void deletePosition(Integer id);

}
