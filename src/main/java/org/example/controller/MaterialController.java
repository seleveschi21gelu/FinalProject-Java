package org.example.controller;

import org.example.entity.Material;
import org.example.entity.Providers;
import org.example.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    private ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> list = materialService.getMaterialList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Material> getMaterialById(@PathVariable Integer id) {
        Material material = materialService.findMaterialById(id);
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Material> addMaterial(@RequestBody Material material) {
        materialService.addMaterial(material);
        return new ResponseEntity<>(material, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Material> updateMaterialById(@PathVariable Integer id, @RequestBody Material material) {
        material.setId(id);
        materialService.updateMaterialById(material);
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Material> deleteMaterialById(@PathVariable Integer id) {
        materialService.deleteMaterialById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
