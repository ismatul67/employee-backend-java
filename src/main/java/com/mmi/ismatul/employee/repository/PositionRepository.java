package com.mmi.ismatul.employee.repository;

import com.mmi.ismatul.employee.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    public Page findAllByRemoveIsFalse(Pageable pageable);
}
