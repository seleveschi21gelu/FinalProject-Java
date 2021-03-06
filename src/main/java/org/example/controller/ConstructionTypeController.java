package org.example.controller;

import org.example.entity.ConstructionType;
import org.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/constructiontype")
public class ConstructionTypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping
    private ResponseEntity<List<ConstructionType>> getAllStatus() {
        List<ConstructionType> typeList = typeService.getAllTypes();
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ConstructionType> getTypeById(@PathVariable Integer id) {
        ConstructionType type = typeService.getTypesById(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ConstructionType> addTypes(@RequestBody ConstructionType type) {
        ConstructionType addType = typeService.addOrUpdateType(type);
        return new ResponseEntity<>(addType, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<ConstructionType>updateTypeById(@RequestBody ConstructionType type, @PathVariable Integer id){
        type.setId(id);
        typeService.addOrUpdateType(type);
        return new ResponseEntity<>(type,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ConstructionType>deleteTypeById(@PathVariable Integer id){
        typeService.deleteTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
