package org.example.service;

import org.example.entity.Offer;
import org.example.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getOffersList() {
        return offerRepository.findAll();
    }

    public List<Offer> findAllOffers() {
        return offerRepository.findAll();
    }

    public Offer findOfferById(Integer id) {
        return offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer by id " + id + " was not found"));
    }

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer updateOfferById(Offer offer) {
        return offerRepository.save(offer);
    }

    public void deleteOfferById(Integer id) {
        offerRepository.deleteById(id);
    }


}
