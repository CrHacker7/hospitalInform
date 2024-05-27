package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Inform;
import java.util.Optional;

public interface InformRepository extends CrudRepository<Inform, String> {
    Optional<Inform> findInformById(String id);
}
