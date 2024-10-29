package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.Doctor;
import com.devstack.ecom.upscale.entity.Routine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoutineRepo extends JpaRepository<Routine,String> {
   @Query(value = "SELECT * FROM routine WHERE duration LIKE %?1% ORDER BY duration DESC", nativeQuery = true)
    public Page<Routine> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM routine WHERE duration LIKE %?1%", nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
