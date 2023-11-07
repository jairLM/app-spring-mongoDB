package com.aleal.empleados.backend.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aleal.empleados.backend.model.Empleado;

public interface IEmpleadoDao extends MongoRepository<Empleado, String> {

}
