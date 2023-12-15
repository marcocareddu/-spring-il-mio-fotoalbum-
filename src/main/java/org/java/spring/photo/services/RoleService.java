package org.java.spring.photo.services;

import java.util.List;
import org.java.spring.photo.auth.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private org.java.spring.photo.repo.RoleRepository roleRepository;
	
	public List<org.java.spring.photo.auth.Role> findAll() {
		return roleRepository.findAll();
	}
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}
	public void save(Role role) {
		roleRepository.save(role);
	}
	public void deleteById(int id) {
		roleRepository.deleteById(id);
	}
}
