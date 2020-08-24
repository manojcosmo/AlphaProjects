 package io.springbootjpa.repository;

import org.springframework.data.repository.CrudRepository;

import io.springbootjpa.entities.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

}
