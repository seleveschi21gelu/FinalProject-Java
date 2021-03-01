package org.example.controller;

import org.example.entity.FlatBlock;
import org.example.service.FlatBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/flatBlock")
public class FlatBlockController {

    @Autowired
    private FlatBlockService flatBlockService;

    @GetMapping
    private ResponseEntity<List<FlatBlock>> findAllFlatBlocks() {
        List<FlatBlock> bills = flatBlockService.flatBlockList();
        return new ResponseEntity(bills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FlatBlock> findFlatBlockById(@PathVariable Integer id) {
        FlatBlock flatBlock = flatBlockService.findFlatBlockById(id);
        return new ResponseEntity<>(flatBlock, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<FlatBlock> addFlatBlock(@RequestBody FlatBlock flatBlock) {
        flatBlockService.addFlatBlock(flatBlock);
        return new ResponseEntity<>(flatBlock, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<FlatBlock> updateFlatBlockById(@PathVariable Integer id, @RequestBody FlatBlock flatBlock) {
        flatBlock.setId(id);
        flatBlockService.updateFlatBlockById(flatBlock);
        return new ResponseEntity<>(flatBlock, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteFlatBlock(@PathVariable Integer id) {
        flatBlockService.deleteFlatBlockById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
