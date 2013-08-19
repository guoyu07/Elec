package com.gs.service;

import java.sql.*;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gs.DAO.ElecDAO;
import com.gs.exception.DontHaveThatDayException;
import com.gs.model.Elec;
import com.gs.util.MyDate;

/**
 * @author GaoShen
 * @packageName com.gs.service
 */
@Transactional
@Component("elecService")
public class ElecService {

	private SessionFactory sessionFactory;

	private ElecDAO elecDAO;

	public boolean delete(int date) {
		try {
			elecDAO.delete(loadElec(date));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public ElecDAO getElecDAO() {
		return elecDAO;
	}

	public List<Elec> getElecs() {
		return this.elecDAO.getElecs();
	}

	public Elec loadElec(int date) {
		return this.elecDAO.loadElec(date);
	}

	public void save(Elec e) throws Exception {

		elecDAO.save(e);

	}

	public void update(Elec e) throws Exception {
		elecDAO.update(e);

	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Resource
	public void setElecDAO(ElecDAO elecDAO) {
		this.elecDAO = elecDAO;
	}

	public List<Elec> search(int month) {
		return elecDAO.search(month);
	}

	public Elec getCurrent() {
		return elecDAO.getCurrent();
	}

	public boolean checkElecWithDate(int date) {
		return elecDAO.checkElecWithDate(date);
	}

	public Elec getBefore(int date) throws Exception {
		return elecDAO.getBefore(date);
	}
}
