package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.modelos.Usuario;

public class HoraLancadaDAO {

	private EntityManager entityManager;
	
	@Inject
	public HoraLancadaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public HoraLancadaDAO() {
	}
	
	public List<HoraLancada> lista() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<HoraLancada> criteria = builder.createQuery(HoraLancada.class);

		Root<HoraLancada> root = criteria.from(HoraLancada.class);
		
		criteria.select(root);

		TypedQuery<HoraLancada> query = entityManager.createQuery(criteria);

		List<HoraLancada> horas = null;
				
		try {
			horas = query.getResultList();
		}
		catch (NoResultException ex) {}
				
		return horas;
	}

	public void adiciona(HoraLancada horaLancada) {
		
		entityManager.getTransaction().begin();
		
		if ( horaLancada.getId() == null || horaLancada.getId() == 0 ) {
			entityManager.persist(horaLancada);
			entityManager.getTransaction().commit();
		}
		else {
			entityManager.merge(horaLancada);
		}
	}

	public List<HoraLancada> horasDoUsuario(Usuario usuario) {
		String jpql = "select h from HoraLancada h "
				+ "where h.usuario = :usuario "
				+ "order by h.data";
		
		TypedQuery<HoraLancada> query = entityManager.createQuery(jpql, HoraLancada.class);
		query.setParameter("usuario", usuario);
		
		List<HoraLancada> horas = null;
		
		try {
			horas = query.getResultList();
		}
		catch (NoResultException ex) {}
				
		return horas;
		
	}

}
