package com.kenya.dojoninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenya.dojoninjas.models.Ninja;
import com.kenya.dojoninjas.repo.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepo ninjaRepo;

	// ======= get all =========
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}

	// ======= Create ========== 
	public Ninja createDojo(Ninja n) {
		return ninjaRepo.save(n);
	}

	// ========= Show one ======= 
	public Ninja showOne(Long id) {
		Optional<Ninja> optionalDojo = ninjaRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

}
