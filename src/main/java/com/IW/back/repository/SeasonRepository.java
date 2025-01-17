package com.IW.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.IW.back.model.Season;
import java.util.Date;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{
    @Query("""
        SELECT s
        FROM Season s
        WHERE s.season_start <= :date AND s.season_end >= :date
    """)
    Season findByDate(Date date);

}
