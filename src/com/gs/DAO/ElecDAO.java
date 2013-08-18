package com.gs.DAO;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.gs.exception.DontHaveThatDayException;
import com.gs.model.Elec;
import com.gs.util.MyDate;

@Component("elecDAO")
public class ElecDAO {

	private HibernateTemplate hibernateTemplate;
	private MyDate m;

	public void delete(Elec e) {
		hibernateTemplate.delete(e);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public List<Elec> getElecs() {
		return (List<Elec>) this.hibernateTemplate.find("from Elec");
	}

	public Elec loadElec(int date) {
		Elec e = (Elec) this.hibernateTemplate.load(Elec.class, date);
		return e;
	}

	public void save(Elec e) {
		hibernateTemplate.save(e);
	}

	public void update(Elec e) {
		hibernateTemplate.merge(e);
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Elec> search(int month) {
		return (List<Elec>) this.hibernateTemplate.find(
				"from Elec e where e.month=?", month);
	}

	public Elec getCurrent() {
		boolean p = true;
		List<Elec> elecs = getElecs();
		Iterator<Elec> iter = elecs.iterator();
		int max = 0;
		while (iter.hasNext()) {
			int date = iter.next().getDate();
			if (date > max)
				max = date;
		}
		return loadElec(max);
	}

	public boolean checkElecWithDate(int date) {
		Session s = hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		long count = (Long) s
				.createQuery(
						"select count(*) from Elec elec where date = :date")
				.setInteger("date", date).uniqueResult();
		s.getTransaction().commit();
		if (count > 0) {
			return true;
		} else
			return false;
	}

	public Elec getBefore(int date) throws Exception {
		Elec e = new Elec();
		boolean b = true;
		MyDate m = new MyDate(date);
		m = m.getBefore();
		int num = 1;
		while (b&&num!=10) {
			if (checkElecWithDate(m.getDate())) {
				b = false;
				e = loadElec(m.getDate());
			} else {
				m = m.getBefore();
			}
			num++;
		}
		return e;
	}
}
