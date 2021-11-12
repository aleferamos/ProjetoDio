package com.github.aleferamos.citiesapi.state.repositories;

import com.github.aleferamos.citiesapi.state.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
