package com.hcl.breach.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.app.entity.BreachInfo;

@Repository
public interface BreachRepository extends JpaRepository<BreachInfo, Long> {

}
