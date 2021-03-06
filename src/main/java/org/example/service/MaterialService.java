package org.example.service;

import org.example.entity.MaterialAndExecution;
import org.example.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

   public List<MaterialAndExecution> getMaterialList (){
        return materialRepository.findAll();
    }
    public List<MaterialAndExecution> findAllMaterials() {
        return materialRepository.findAll();
    }

    public MaterialAndExecution findMaterialById(Integer id) {
        return materialRepository.findById(id).orElseThrow(() -> new RuntimeException("Materials by id " + id + " was not found"));
    }
    public MaterialAndExecution addMaterial(MaterialAndExecution materialAndExecution) {
        return materialRepository.save(materialAndExecution);
    }

    public MaterialAndExecution updateMaterialById(MaterialAndExecution materialAndExecution) {
        return materialRepository.save(materialAndExecution);
    }

    public void deleteMaterialById(Integer id) {
        materialRepository.deleteById(id);
    }



}
