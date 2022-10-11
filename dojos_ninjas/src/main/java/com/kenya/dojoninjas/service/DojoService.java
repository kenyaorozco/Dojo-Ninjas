package com.kenya.dojoninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenya.dojoninjas.models.Dojo;
import com.kenya.dojoninjas.repo.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	
	// =========== get all =========== 
		public List <Dojo> allDojos(){
			return dojoRepo.findAll();
		}
		
	// ========= Create ======== 
		public Dojo createDojo(Dojo d) {
			return dojoRepo.save(d);
		}
		
		
	// ========== Show one ====== 
		public Dojo showOne(Long id){
			Optional<Dojo> optionalDojo = dojoRepo.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
		}
		

}
