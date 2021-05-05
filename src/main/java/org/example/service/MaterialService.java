package org.example.service;

import org.example.entity.Material;
import org.example.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

   public List<Material> getMaterialList (){

       return materialRepository.findAll();
    }


    public Material findMaterialById(Integer id) {
        return materialRepository.findById(id).orElseThrow(() -> new RuntimeException("Materials by id " + id + " was not found"));
    }
    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }

    public Material updateMaterialById(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterialById(Integer id) {
        materialRepository.deleteById(id);
    }



}
