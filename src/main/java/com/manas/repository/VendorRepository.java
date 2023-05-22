package com.manas.repository;

import com.manas.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
//    @Query("from Vendor where firstName ilike :keyWord")
//    List<Vendor> search(String keyWord);
}
