package com.kindsonthegenius.r4u.parameters.repositories;

import com.kindsonthegenius.r4u.parameters.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
