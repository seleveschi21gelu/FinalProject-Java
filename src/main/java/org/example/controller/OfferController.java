package org.example.controller;

import org.example.entity.Offer;
import org.example.repository.OfferRepository;
import org.example.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    private ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offer = offerService.getOffersList();
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Offer> getOffersById(@PathVariable Integer id) {
        Offer offer = offerService.findOfferById(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Offer> addOffers(@RequestBody Offer offer) {
        offerService.addOffer(offer);
        return new ResponseEntity<>(offer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Offer> updateOfferById(@RequestBody Offer offer, @PathVariable Integer id) {
        offer.setId(id);
        offerService.updateOfferById(offer);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Offer> deleteOfferById(@PathVariable Integer id) {
        offerService.deleteOfferById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
