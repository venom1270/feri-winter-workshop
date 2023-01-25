package com.example.demo.dao;

import com.example.demo.vao.BancniRacun;
import com.example.demo.vao.Oseba;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BancniRacunRepo extends CrudRepository<BancniRacun, String> {

}
