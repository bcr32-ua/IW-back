package com.IW.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.IW.back.model.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    @Query("""
        SELECT r
        FROM Room r
        LEFT JOIN Booking b ON r.id = b.room.id
        WHERE NOT (
            b.start_date < :endDate AND
            b.end_date > :startDate
        )
        OR b.id IS NULL
    """)
    List<Room> findAvailableRooms(@Param("startDate") String startDate, @Param("endDate") String endDate);
}

