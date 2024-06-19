package miu.edu.cse.adsdentalsurgeries.address.service;

import miu.edu.cse.adsdentalsurgeries.address.model.Address;

import java.util.List;


public interface AddressService {

	Integer createNewAddress(Address address);
	
	List<Address> findAddresses();
}
