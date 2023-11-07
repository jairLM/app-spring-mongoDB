package com.aleal.empleados.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aleal.empleados.backend.model.Empleado;
import com.aleal.empleados.backend.service.IEmpleadoService;

@Controller
@RequestMapping("/")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", empleadoService.buscar());
		return "index";
	}
	
	@PostMapping("/guardar")
	public String save(Empleado empleado, Model model) {
		
		empleadoService.guardarEmpleado(empleado);
		return "redirect:/";
		
	}
	
	@GetMapping("/guardar/{id}")
	public String showSave(@PathVariable("id")String id, Model model) {
		if(id != null && !"0".equals(id)) {
			model.addAttribute("empleado", empleadoService.buscarPorId(id));
		}else {
			model.addAttribute("empleado", new Empleado());
		}
		return "guardar";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		empleadoService.eliminarPorId(id);
		return "redirect:/";
	}
}
