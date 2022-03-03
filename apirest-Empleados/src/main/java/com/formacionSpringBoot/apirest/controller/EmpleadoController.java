package com.formacionSpringBoot.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionSpringBoot.apirest.entity.Empleado;
import com.formacionSpringBoot.apirest.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping({"/empleados"})
	public List<Empleado> index(){
		return servicio.findAll();
	}
	
	@GetMapping("empleados/{idEmpleado}")
	public ResponseEntity<?>  findEmpleadoById(@PathVariable Long idEmpleado) {
		Empleado empleado = null;
		Map<String, Object> response=new HashMap<>();
		
		try {
			empleado = servicio.findById(idEmpleado);
		}catch (DataAccessException e) {//MUY ESPECÍFICO, EXCEPCIONES SOBRE EL DAO
			response.put("mensaje", "Error al rellenar la consulta a base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(empleado ==null) {
		response.put("mensaje", "El Código de empleado: ".concat(idEmpleado.toString().concat(" no existe en la base de datos")));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	}
	
	@PostMapping("/empleado")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveEmpleado(@RequestBody Empleado empleado) {
		Map<String, Object> response = new HashMap<>();

		try {
			servicio.save(empleado);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la insert a la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El empleado ha sido creado con exito!");
		response.put("cliente", empleado);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/empleado/{idEmpleado}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> upDateEmpleado(@RequestBody Empleado empleado, @PathVariable Long idEmpleado) {

		Empleado empleadoActual = servicio.findById(idEmpleado);

		Map<String, Object> response = new HashMap<>();

		if (empleadoActual == null) {
			response.put("mensaje", "El Empleado ID: ".concat(idEmpleado.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			empleadoActual.setIdEmpleado(idEmpleado);
			empleadoActual.setDNI(empleadoActual.getDNI());
			empleadoActual.setNombre(empleadoActual.getNombre());
			empleadoActual.setSalario(empleadoActual.getSalario());
			empleadoActual.setTelefono(empleadoActual.getTelefono());
			empleadoActual.setDepartamentos(empleadoActual.getDepartamentos());
			
			

			servicio.save(empleadoActual);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la actualización a la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El cliente ha sido actualizado con exito!");
		response.put("cliente", empleadoActual);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/clientes/{codCliente}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable Long idEmpleado) {

		Empleado empleadoABorrar = servicio.findById(idEmpleado);

		Map<String, Object> response = new HashMap<>();

		if (empleadoABorrar == null) {
			response.put("mensaje", "El empleado ID: ".concat(idEmpleado.toString().concat(" no se pudo eliminar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			servicio.delete(idEmpleado);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la eliminación en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El empleado ha sido borrado con exito!");
		response.put("cliente", empleadoABorrar);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
