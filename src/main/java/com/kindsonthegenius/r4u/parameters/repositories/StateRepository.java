package com.kindsonthegenius.r4u.parameters.repositories;

import com.kindsonthegenius.r4u.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
