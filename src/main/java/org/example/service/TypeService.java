package org.example.service;

import org.example.entity.Type;
import org.example.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypesById(Integer id) {
        return typeRepository.findById(id).orElseThrow(() -> new RuntimeException("The type fom id " + id + "was not found"));
    }

    public Type addOrUpdateType(Type type) {
        return typeRepository.save(type);
    }

    public void deleteTypeById(Integer id) {
        typeRepository.deleteById(id);
    }


}
