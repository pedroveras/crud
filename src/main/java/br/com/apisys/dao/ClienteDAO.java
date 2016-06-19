package br.com.apisys.dao;

import java.util.List;

import br.com.apisys.model.Cliente;

public interface ClienteDAO {
	public void addCliente(Cliente c);
	public List<Cliente> listarClientes();
	public void deletarCliente(Integer id);
	public void atualizarCliente(Cliente c);
	public Cliente getClientById(Integer id);
}
