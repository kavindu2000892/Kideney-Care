package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Doctor;
import com.devstack.ecom.upscale.entity.Signs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SignsRepo extends JpaRepository<Signs,String> {
   @Query(value = "SELECT * FROM signs WHERE date LIKE %?1% ORDER BY date DESC", nativeQuery = true)
    public Page<Signs> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM signs WHERE date LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
