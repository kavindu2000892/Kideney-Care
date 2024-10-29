package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepo extends JpaRepository<Patient,String> {
   @Query(value = "SELECT * FROM patient WHERE contact LIKE %?1% ORDER BY contact DESC", nativeQuery = true)
    public Page<Patient> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM patient WHERE contact LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
