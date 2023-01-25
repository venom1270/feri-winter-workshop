package com.example.demo.dao;

import com.example.demo.vao.Oseba;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OsebaRepo extends CrudRepository<Oseba, Integer> {

    List<Oseba> findAllByIme(String name);

}
