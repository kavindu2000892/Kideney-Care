package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Doctor;
import com.devstack.ecom.upscale.entity.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TreatmentRepo extends JpaRepository<Treatment,String> {
   @Query(value = "SELECT * FROM treatment WHERE dialyzer_type LIKE %?1% ORDER BY dialyzer_type DESC", nativeQuery = true)
    public Page<Treatment> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM treatment WHERE dialyzer_type LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
