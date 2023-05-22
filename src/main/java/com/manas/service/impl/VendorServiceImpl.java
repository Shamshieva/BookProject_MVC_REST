package com.manas.service.impl;

import com.manas.entity.Vendor;
import com.manas.repository.VendorRepository;
import com.manas.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public void save(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    @Override
    public void delete(Long id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public Vendor getById(Long id) {
        return vendorRepository
                .findById(id).orElseThrow(
                        ()-> new NoSuchElementException("Vendor by id " + id + " not found"));
    }

    @Override
    public void update(Long id, Vendor vendor) {
        Vendor vendor1 = vendorRepository
                .findById(id).orElseThrow(
                        ()-> new NoSuchElementException("Vendor by id " + id + " not found"));
        vendor1.setFirstName(vendor.getFirstName());
        vendor1.setLastName(vendor.getLastName());
        vendor1.setImage(vendor.getImage());
        vendor1.setIsActive(vendor1.getIsActive());
        vendor1.setDescription(vendor.getDescription());
        vendor1.setPhoneNumber(vendor.getPhoneNumber());

        vendorRepository.save(vendor1);
    }

//    @Override
//    public List<Vendor> getAllVendors(String keyWord) {
//        if (keyWord != null && !keyWord.trim().isEmpty()){
//            return vendorRepository.search("%" + keyWord + "%");
//        } else {
//            return vendorRepository.findAll();
//        }
//    }
}
