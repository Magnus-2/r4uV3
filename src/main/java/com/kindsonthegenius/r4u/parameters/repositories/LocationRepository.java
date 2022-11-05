package com.kindsonthegenius.r4u.parameters.repositories;

import com.kindsonthegenius.r4u.parameters.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
