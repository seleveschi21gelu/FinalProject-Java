package org.example.controller;

import org.example.entity.MaterialAndExecution;
import org.example.entity.MaterialDto;
import org.example.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    private ResponseEntity<List<MaterialAndExecution>> getAllMaterials() {
        List<MaterialAndExecution> list = materialService.getMaterialList();
//        List<MaterialDto> materialDtos = new ArrayList<>();
//        for (MaterialAndExecution material : list) {
//            materialDtos.add(new MaterialDto(material.getName(), material.getDeliveryType().getName()));
//        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<MaterialAndExecution> getMaterialById(@PathVariable Integer id) {
        MaterialAndExecution materialAndExecution = materialService.findMaterialById(id);
        return new ResponseEntity<>(materialAndExecution, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<MaterialAndExecution> addMaterial(@RequestBody MaterialAndExecution materialAndExecution) {
        materialService.addMaterial(materialAndExecution);
        return new ResponseEntity<>(materialAndExecution, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<MaterialAndExecution> updateMaterialById(@PathVariable Integer id, @RequestBody MaterialAndExecution materialAndExecution) {
        materialAndExecution.setId(id);
        materialService.updateMaterialById(materialAndExecution);
        return new ResponseEntity<>(materialAndExecution, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<MaterialAndExecution> deleteMaterialById(@PathVariable Integer id) {
        materialService.deleteMaterialById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
