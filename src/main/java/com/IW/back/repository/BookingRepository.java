package com.IW.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IW.back.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
