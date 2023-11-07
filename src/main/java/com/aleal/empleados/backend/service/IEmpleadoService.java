package com.aleal.empleados.backend.service;

import java.util.List;

import com.aleal.empleados.backend.model.Empleado;

public interface IEmpleadoService {

	List<Empleado> buscar();
	
	Empleado buscarPorId(String id);
	
	Empleado guardarEmpleado(Empleado empleado);
	
	void eliminarPorId(String id);
	
	
	
}
