package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Summery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SummeryRepo extends JpaRepository<Summery,String> {
   @Query(value = "SELECT * FROM summery WHERE symptms LIKE %?1% ORDER BY symptms DESC", nativeQuery = true)
    public Page<Summery> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM summery WHERE symptms LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
