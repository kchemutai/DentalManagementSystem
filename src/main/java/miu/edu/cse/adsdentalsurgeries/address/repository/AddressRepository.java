package miu.edu.cse.adsdentalsurgeries.address.repository;

import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AddressRepository extends JpaRepository<Address, Integer> {
    public Optional<Address> findAddressByCity(String city);
    public Optional<Address> findAddressByState(String state);
}
