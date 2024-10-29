package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Doctor;
import com.devstack.ecom.upscale.entity.Upcoming;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UpcomingRepo extends JpaRepository<Upcoming,String> {
   @Query(value = "SELECT * FROM upcoming WHERE date LIKE %?1% ORDER BY date DESC", nativeQuery = true)
    public Page<Upcoming> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM upcoming WHERE date LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
