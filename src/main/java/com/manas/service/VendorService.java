package com.manas.service;

import com.manas.entity.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> getAllVendors();

    void save(Vendor vendor);

    void delete(Long id);

    Vendor getById(Long id);

    void update(Long id, Vendor vendor);

//    List<Vendor> getAllVendors(String keyWord);
}
