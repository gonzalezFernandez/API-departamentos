package com.projecto.java.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.java.Dao.ClienteRepository;
import com.projecto.java.entity.Cliente;
import com.projecto.java.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	
	@Override
	public void delete(Long codCliente) {
		repositorio.deleteById(codCliente);

	}

	@Override
	public List<Cliente> findAll() {		
		return (List<Cliente>) repositorio.findAll();
	}

	@Override
	public Cliente findById(Long codCliente) {		
		return repositorio.findById(codCliente).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {		
		return repositorio.save(cliente);
	}

//	Pendiente
	@Override
	public Cliente deleteConRetorno(Long codCliente) {		
		Cliente c = repositorio.findById(codCliente).get();
		repositorio.deleteById(codCliente);
		return c;
	}

}
