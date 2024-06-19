package miu.edu.cse.adsdentalsurgeries.address.service.impl;

import java.util.List;


import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.address.repository.AddressRepository;
import miu.edu.cse.adsdentalsurgeries.address.service.AddressService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
	
	private final AddressRepository addressRepository;
	
	@Override
	public Integer createNewAddress(Address address) {
		log.info("A new Address with id=" + address.getId() + " will be created!");
	
		addressRepository.save(address);
		
		//BeanUtils.copyProperties(sourceObject, targetObject);
		
		log.info("The Address with id=" + address.getId() + " is created!");
		
		return address.getId();
	}

	@Override
	public List<Address> findAddresses() {
		return addressRepository.findAll();
	}

}
