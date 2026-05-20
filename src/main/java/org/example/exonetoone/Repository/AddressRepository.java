package org.example.exonetoone.Repository;

import jakarta.transaction.Transactional;
import org.example.exonetoone.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a WHERE a.id = ?1")
    Address findAddressById(Integer id);

    @Query("DELETE FROM Address a WHERE a.id= ?1")
    @Modifying
    @Transactional
    void deleteAddressById(Integer id);
}
