package com.zup.TesteDev.repository;

import com.zup.TesteDev.domain.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends JpaRepository<Poi, Long> {

}
