package br.edu.ifms.crudspring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Parent;
import br.edu.ifms.crudspring.repository.ParentRepository;

@Service
public class ParentService {

    @Autowired // cria automaticamente os objetos
    ParentRepository parentRepository;

    public List<Parent> getParents() {
        return parentRepository.findAll();
    }

    public void save(Parent parent) {
        parentRepository.save(parent);
    }

    public void delete(UUID id) {
        parentRepository.deleteById(id);
    }

    public Parent findById(UUID id) {
        return parentRepository.findById(id).get();
    }
}
