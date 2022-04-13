package br.edu.ifms.crudspring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.crudspring.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, UUID> {

}
