package com.aleal.empleados.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleal.empleados.backend.dao.IEmpleadoDao;
import com.aleal.empleados.backend.model.Empleado;
import com.aleal.empleados.backend.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	
	@Override
	public List<Empleado> buscar() {
				
		return empleadoDao.findAll();
	}

	@Override
	public Empleado buscarPorId(String id) {
		Optional<Empleado> empleado = empleadoDao.findById(id);
		if(empleado.isPresent()) {
			return empleado.get();
		}
		return null;
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		
		return empleadoDao.save(empleado);
	}

	@Override
	public void eliminarPorId(String id) {
		
		empleadoDao.deleteById(id);
	}
	
	
}
