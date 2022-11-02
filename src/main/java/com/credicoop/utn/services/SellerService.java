package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Seller;
import com.credicoop.utn.exceptions.product.SellerNotFoundException;
import com.credicoop.utn.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SellerService {


    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }


    public void addSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {

        if (!sellerRepository.existsById(id)) {

            throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND + id);

        }

        sellerRepository.deleteById(id);

    }


    public Seller getSeller(Long id) {

        Optional<Seller> seller = sellerRepository.findById(id);
        if (!seller.isPresent()) {

            throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND + id);

        }

        return seller.get();

    }


    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }


}
