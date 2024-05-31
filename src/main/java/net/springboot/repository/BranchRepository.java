package net.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

	
}
