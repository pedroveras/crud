package br.com.apisys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.apisys.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}

	public void addCliente(Cliente c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
	}

	public List<Cliente> listarClientes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cliente> listaClientes = session.createQuery("from Cliente").getResultList();
		return listaClientes;
	}

	public void deletarCliente(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente)session.load(Cliente.class, new Integer(id));
		if (c != null) {
			session.delete(c);
		}
	}

	public void atualizarCliente(Cliente c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);

	}

	public Cliente getClientById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente)session.get(Cliente.class,new Integer(id));
		
		return c;
	}
	
	
	

}
