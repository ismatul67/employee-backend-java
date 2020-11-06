package com.mmi.ismatul.employee.controllers;

import com.mmi.ismatul.employee.entity.Position;
import com.mmi.ismatul.employee.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
    @RequestMapping("/position")
    public class PositionController {
        @Autowired
        PositionService positionService;
        @PostMapping
        public Position createPosition(@RequestBody Position position){
            return positionService.savePosition(position);
        }
        @GetMapping("/{id}")
        public Position getPositionById(@PathVariable Integer id){
            return positionService.getPositionById(id);
        }
        @GetMapping
        public Page<Position> getPositionsByPage(@RequestParam (defaultValue ="20", value = "size") Integer size, @RequestParam (defaultValue ="1", value = "page")Integer page){
            Pageable pageable = PageRequest.of(page-1, size);
            return positionService.getPositions(pageable);
        }
        @PutMapping
        public Position updatePosition(@RequestBody Position position){
            return positionService.savePosition(position);
        }
        @DeleteMapping("/{id}")
        public void destroyerPosition(@PathVariable Integer id){
            positionService.deletePosition(id);
        }
}
