package br.com.alura.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.alura.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDAO {

	private EntityManager entityManager;
	
	@Inject
	public UsuarioDAO(EntityManager entityManager) {

		this.entityManager = entityManager;
		
	}
	
	public UsuarioDAO() { }
	
	public void adiciona(Usuario usuario) {
		
		entityManager.getTransaction().begin();
		
		try {
			
			entityManager.persist(usuario);
			
			entityManager.getTransaction().commit();
			
		}catch (Exception ex) {

			ex.printStackTrace();

			entityManager.getTransaction().rollback();
		}
		
		
	}
	
	public List<Usuario> lista(){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		
		Root<Usuario> root = criteria.from(Usuario.class);
		
		criteria.select(root);
		
		TypedQuery<Usuario> query = entityManager.createQuery(criteria);
		
		List<Usuario> list = null;
		
		try {
			list = query.getResultList();
		}
		catch (NoResultException ex) {}
				
		return list;
		
	}

	public Usuario busca(String login, String senha) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);

		Root<Usuario> root = criteria.from(Usuario.class);

		criteria.select(root).where(builder.equal(root.get("login"), login),
									builder.equal(root.get("senha"), senha));

		TypedQuery<Usuario> query = entityManager.createQuery(criteria);

		Usuario usuario = null; 
				
		try {
			usuario = query.getSingleResult();
		}
		catch (NoResultException ex) {}
				
		return usuario;
	}
	
}
