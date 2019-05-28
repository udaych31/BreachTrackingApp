package com.hcl.breach.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.breach.app.entity.BreachInfo;

@Repository
public interface BreachRepository extends JpaRepository<BreachInfo, Long> {
    public BreachInfo findByBreachId(Long breachId);
	


    @Modifying
    @Transactional   
	public void updateBreachStatus(@Param("status") String status,@Param("breachId") Long id);

}
