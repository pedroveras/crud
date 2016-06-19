package br.com.apisys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.apisys.dao.ClienteDAO;
import br.com.apisys.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteDAO clienteDAO;	
	
	public void setClienteDAO (ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
		
	@Transactional
	public void addCliente(Cliente c) {
		this.clienteDAO.addCliente(c);
	}

	@Transactional
	public List<Cliente> listarClientes() {
		return this.clienteDAO.listarClientes();
	}

	@Transactional
	public void deletarCliente(Integer id) {
		this.clienteDAO.deletarCliente(id);
	}

	@Transactional
	public void atualizarCliente(Cliente c) {
		this.clienteDAO.atualizarCliente(c);
	}
	
	@Transactional
	public Cliente getClienteById(Integer id) {
		return this.clienteDAO.getClientById(id);
	}
	
}
