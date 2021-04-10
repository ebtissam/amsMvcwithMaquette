package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

	 @Query("select p from Provider p  where p.address like %?1 and p.name like %?2")
	    List<Provider> findProviderByAddress(String ad, String name);
}
