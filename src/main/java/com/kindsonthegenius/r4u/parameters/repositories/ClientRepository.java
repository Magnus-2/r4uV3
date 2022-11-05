package com.kindsonthegenius.r4u.parameters.repositories;

import com.kindsonthegenius.r4u.parameters.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
