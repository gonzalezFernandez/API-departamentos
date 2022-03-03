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

import com.formacionSpringBoot.apirest.entity.Jefe;
import com.formacionSpringBoot.apirest.service.JefeService;



@RestController
@RequestMapping("/api")
public class JefeController {

	@Autowired
	private JefeService servicio;
	
	@GetMapping({"/jefes"})
	public List<Jefe> index(){
		return servicio.findAll();
	}
	
	@GetMapping("jefes/{idJefe}")
	public ResponseEntity<?>  findEmpleadoById(@PathVariable Long idJefe) {
		Jefe jefe = null;
		Map<String, Object> response=new HashMap<>();
		
		try {
			jefe = servicio.findById(idJefe);
		}catch (DataAccessException e) {//MUY ESPECÍFICO, EXCEPCIONES SOBRE EL DAO
			response.put("mensaje", "Error al rellenar la consulta a base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(jefe ==null) {
		response.put("mensaje", "El Código de Jefe: ".concat(idJefe.toString().concat(" no existe en la base de datos")));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		return new ResponseEntity<Jefe>(jefe, HttpStatus.OK);
	}
	
	@PostMapping("/jefe")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveEmpleado(@RequestBody Jefe jefe) {
		Map<String, Object> response = new HashMap<>();

		try {
			servicio.save(jefe);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la insert a la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El Jefe ha sido creado con exito!");
		response.put("cliente", jefe);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/jefe/{idJefe}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> upDateEmpleado(@RequestBody Jefe jefe, @PathVariable Long idJefe) {

		Jefe jefeActual = servicio.findById(idJefe);

		Map<String, Object> response = new HashMap<>();

		if (jefeActual == null) {
			response.put("mensaje", "El Jefe ID: ".concat(idJefe.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			jefeActual.setIdJefe(idJefe);
			jefeActual.setDNI(jefeActual.getDNI());
			jefeActual.setNombre(jefeActual.getNombre());
			jefeActual.setSalario(jefeActual.getSalario());
			jefeActual.setTelefono(jefeActual.getTelefono());
			jefeActual.setDepartamentos(jefeActual.getDepartamentos());
			
			

			servicio.save(jefeActual);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la actualización a la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El Jefe ha sido actualizado con exito!");
		response.put("cliente", jefeActual);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/jefes/{idJefe}")
	public ResponseEntity<?> deleteJefe(@PathVariable Long idJefe) {

		Jefe jefeABorrar = servicio.findById(idJefe);

		Map<String, Object> response = new HashMap<>();

		if (jefeABorrar == null) {
			response.put("mensaje", "El Jefe ID: ".concat(idJefe.toString().concat(" no se pudo eliminar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			servicio.delete(idJefe);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la eliminación en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El Jefe ha sido borrado con exito!");
		response.put("cliente", jefeABorrar);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}