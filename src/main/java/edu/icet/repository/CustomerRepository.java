package edu.icet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<edu.icet.entity.Customer, Long> {

    Optional<edu.icet.entity.Customer> findByEmail(String email);
    Optional<edu.icet.entity.Customer> findByNic(String nic);
    Boolean existsByEmail(String email);


}
