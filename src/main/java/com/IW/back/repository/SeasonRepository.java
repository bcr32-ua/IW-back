package com.IW.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IW.back.model.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{
}
