package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepo extends JpaRepository<Doctor,String> {
   @Query(value = "SELECT * FROM doctor WHERE contact LIKE %?1% ORDER BY contact DESC", nativeQuery = true)
    public Page<Doctor> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM doctor WHERE contact LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
