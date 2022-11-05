package com.kindsonthegenius.r4u.parameters.repositories;

import com.kindsonthegenius.r4u.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
