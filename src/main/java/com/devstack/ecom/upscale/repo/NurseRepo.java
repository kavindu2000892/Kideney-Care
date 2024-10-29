package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Doctor;
import com.devstack.ecom.upscale.entity.Nurse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NurseRepo extends JpaRepository<Nurse,String> {
   @Query(value = "SELECT * FROM nurse WHERE contact LIKE %?1% ORDER BY contact DESC", nativeQuery = true)
    public Page<Nurse> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM nurse WHERE contact LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
