package com.gs.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gs.model.Elec;
import com.gs.service.ElecService;
import com.gs.util.JavaMail;
import com.gs.util.MyDate;

@Component("frameAction")
public class FrameAction {
	public int getInputelec() {
		return inputelec;
	}

	public void setInputelec(int inputelec) {
		this.inputelec = inputelec;
	}

	private Elec elec;
	private int elecnum;
	private ElecService ElecService;
	private MyDate myDate = new MyDate();

	public int getElecnum() {
		return elecnum;
	}

	public void setElecnum(int elecnum) {
		this.elecnum = elecnum;
	}

	public ElecService getElecService() {
		return ElecService;
	}

	@Resource
	public void setElecService(ElecService elecService) {
		ElecService = elecService;
	}

	private int inputelec;
	private JavaMail jm = new JavaMail();
	private int used;
	private static String MAILADDR = "63388@qq.com";

	public String regist() throws Exception {
		try {
			elec = new Elec();
			elec.setDay(myDate.getDay());
			elec.setElecnum(elecnum);
			elec.setMonth(myDate.getMonth());
			elec.setYear(myDate.getYear());
			elec.setDate(myDate.getDate());
			elec.setInputelec(inputelec);
			used = 0;
			Elec be = ElecService.getBefore(myDate.getDate());
			if (elecnum < be.getElecnum()) {
				used = be.getElecnum() - elecnum; // һ����r���������x�����ֵ
			} else {
				used = be.getElecnum() - (elecnum - inputelec); // �ȳ�ֵ��Ȕ�
			}
			elec.setUsed(used);
			ElecService.save(elec);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			return "havedone";
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return "havedone";
		}
		jm.doSendHtmlEmail("���յ��������룬ͨ��Client", "Today elecnum = " + elecnum
				+ "  used = " + used + "  input = " + inputelec, MAILADDR);
		return "�ɹ���  "+"���յ��������룬ͨ��Client  "+"���յ��� = " + elecnum
				+ "  ����ʹ�� = " + used + "  ��ֵ = " + inputelec;
	}
}
