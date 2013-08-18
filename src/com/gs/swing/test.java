/*
 * test.java
 *
 * Created on __DATE__, __TIME__
 */

package com.gs.swing;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.gs.action.FrameAction;
import com.gs.util.MyDate;

/**
 *
 * @author  __USER__
 */
@Component("frame")
public class test extends javax.swing.JFrame {

	/** Creates new form test */
	public test() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jFrame1 = new javax.swing.JFrame();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(
				jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("\u597d");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jLabel1.setText("\u4eca\u65e5\u7535\u91cf");

		jLabel2.setText("\u4eca\u65e5\u5145\u503c");

		jLabel4.setText("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(77, 77, 77)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel1)
												.addComponent(jLabel2))
								.addGap(124, 124, 124)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														201, Short.MAX_VALUE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														201, Short.MAX_VALUE))
								.addContainerGap(194,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										0,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(318, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4)
												.addComponent(jButton1))
								.addGap(281, 281, 281)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(80, 80, 80)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
								.addGap(14, 14, 14)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(45, 45, 45)
								.addComponent(jButton1)
								.addGap(46, 46, 46)
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel4)
								.addContainerGap(85, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		FrameAction fa = (FrameAction) ctx.getBean("frameAction");
		fa.setElecnum(Integer.parseInt(jTextField1.getText()));
		if(jTextField2.getText().equals(""))	jTextField2.setText("0");
		fa.setInputelec(Integer.parseInt(jTextField2.getText()));
		try {
			jLabel4.setText(fa.regist());
		} catch (Exception e) {
			jLabel4.setText("ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				t = new test()/*.setVisible(true)*/;
				t.setVisible(true);
				t.setName("��������ͻ���");
				
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private static test t;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}