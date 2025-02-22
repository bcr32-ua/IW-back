package com.IW.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IW.back.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
}
