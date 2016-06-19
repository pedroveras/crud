package br.com.apisys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.apisys.model.Cliente;
import br.com.apisys.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@RequestMapping(value="/cliente/incluir", method = RequestMethod.POST)
	public String inserir(@ModelAttribute("cliente") Cliente c){
		if (c.getId() == null) {
			this.clienteService.addCliente(c);
		} else {
			this.clienteService.atualizarCliente(c);
		}
		return "redirect:/clientes";
	}
	
	@RequestMapping("/editar/{id}")
	public String prepareEditar (@PathVariable("id") Integer id, Model modelo) {
		modelo.addAttribute("cliente",this.clienteService.getClienteById(id));
		modelo.addAttribute("listaClientes",this.clienteService.listarClientes());
		//clienteService.atualizarCliente(c);
		return "cliente";
	}
	
	
	@RequestMapping("/deletar/{id}")
	public String deletar (@PathVariable("id") Integer id) {
		this.clienteService.deletarCliente(id);
		return "redirect:/clientes";
	}
	
	@RequestMapping(value="/clientes", method = RequestMethod.GET)
	public String listar (Model modelo) {
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("listaClientes",this.clienteService.listarClientes());
		return "cliente";
	}
}
