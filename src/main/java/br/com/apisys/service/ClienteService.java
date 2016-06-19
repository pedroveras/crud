package br.com.apisys.service;

import java.util.List;

import br.com.apisys.model.Cliente;

public interface ClienteService {
	public void addCliente(Cliente c);
	public List<Cliente> listarClientes();
	public void deletarCliente(Integer id);
	public void atualizarCliente(Cliente c);
	public Cliente getClienteById(Integer id);
}
