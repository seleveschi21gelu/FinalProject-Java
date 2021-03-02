package org.example.service;

import org.example.entity.FlatBlock;
import org.example.repository.FlatBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatBlockService {

    @Autowired
    private FlatBlockRepository flatBlockRepository;

    public List<FlatBlock> flatBlockList() {
        return flatBlockRepository.findAll();
    }

    public FlatBlock findFlatBlockById(Integer id) {
        return flatBlockRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice by id " + id + " was not found"));
    }

    public FlatBlock addFlatBlock(FlatBlock flatBlock) {

        return flatBlockRepository.save(flatBlock);
    }



    public FlatBlock updateFlatBlockById(FlatBlock flatBlock) {
        return flatBlockRepository.save(flatBlock);
    }

    public void deleteFlatBlockById(Integer id) {
        flatBlockRepository.deleteById(id);
    }

//    static List<Type> typeList = new ArrayList<>();
////    static List<FlatBlock> flatBlockList = new ArrayList<>(typeList);
//
//    static {
//        typeList.add(new Type("Red"));
//        typeList.add(new Type("Gray"));
//        typeList.add(new Type("Finished"));
//    }


}
