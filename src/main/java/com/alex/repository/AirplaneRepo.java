package com.alex.repository;

import com.alex.model.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepo extends CrudRepository<Airplane,Long> {}
