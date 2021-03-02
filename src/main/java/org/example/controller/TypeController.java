package org.example.controller;

import org.example.entity.Type;
import org.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping
    private ResponseEntity<List<Type>> getAllStatus() {
        List<Type> typeList = typeService.getAllTypes();
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Type> getTypeById(@PathVariable Integer id) {
        Type type = typeService.getTypesById(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Type> addTypes(@RequestBody Type type) {
        Type addType = typeService.addOrUpdateType(type);
        return new ResponseEntity<>(addType, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<Type>updateTypeById(@RequestBody Type type, @PathVariable Integer id){
        type.setId(id);
        typeService.addOrUpdateType(type);
        return new ResponseEntity<>(type,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Type>deleteTypeById(@PathVariable Integer id){
        typeService.deleteTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
