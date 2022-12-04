package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.dto.CustomizedProductDTO;
import com.credicoop.utn.dto.SellerDTO;
import com.credicoop.utn.dto.ShopDTO;
import com.credicoop.utn.entities.Seller;
import com.credicoop.utn.exceptions.product.SellerNotFoundException;
import com.credicoop.utn.repositories.SellerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Service
public class SellerService {


    private final SellerRepository sellerRepository;
    private final ShopService shopService;

    public SellerService(SellerRepository sellerRepository, ShopService shopService) {
        this.sellerRepository = sellerRepository;
        this.shopService = shopService;
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

    public void addCustomizedProductBySeller(CustomizedProductDTO customizedProductDTO, String sellerId, String shopId){

        ResponseEntity<SellerDTO> consultSeller = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/seller/" + sellerId, SellerDTO.class);



        if(!consultSeller.getStatusCode().isError()) {

            new RestTemplate().postForLocation("http://localhost:8080/api/v1/shop/"+ shopId +"/add/customizedProductByShop", customizedProductDTO);

        }

    }

    public void addShopBySeller(ShopDTO shopDTO, String sellerId){

        ResponseEntity<SellerDTO> consult = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/seller/" + sellerId, SellerDTO.class);

        shopDTO.setSellerId(Long.parseLong(sellerId));

        if(!consult.getStatusCode().isError()){

            new RestTemplate().postForLocation("http://localhost:8080/api/v1/shop/add", shopDTO);


        }

    }

    public Seller getSeller(Long id) {


        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isEmpty()) {

            throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND + id);

        }

        return seller.get();

    }


    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }


}
