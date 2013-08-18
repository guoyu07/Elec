package com.gs.test;

import java.util.Properties;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.AddressException;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
/** 
 *  
 *  
 * <p>Title: Java�����ʼ������� /p> 
 * 
16. * <p>Description: ʾ�� ҵ����</p> 
17. * 
18. * <p>Copyright: Copyright (c) 2012</p> 
19. * 
20. * 
21. * @author dml@2012-12-17 
22. * @version 1.0 
23. */  
  
/**************************************************************** 
26. * ��QQ����ʹ�ã�����������ʹ�����Ƶ���Ӧ��Ҳ������ˣ� ���Ȱ�QQ�����POP3 SMTP�� ����ȷ����������������Ǵ��� 
27. * ��ȷ�����QQ���俪����SMTP���������� ���û�п�������ô���������� ����->�˻� --������-- �����ѡ�� [��]SMTP���ź󱣴浽������ 
28. ****************************************************************/  
public class JavaMail {  
  
    // ���÷�����  
    private static String KEY_SMTP = "mail.smtp.host";  
    private static String VALUE_SMTP = "smtp.qq.com";  
    // ��������֤  
    private static String KEY_PROPS = "mail.smtp.auth";  
    private static boolean VALUE_PROPS = true;  
    // �������û���������  
    private String SEND_USER = "574361375@qq.com";  
    private String SEND_UNAME = "574361375@qq.com";  
    private String SEND_PWD = "fashion19940409";  
    // �����Ự  
    private MimeMessage message;  
    private Session s;  
  
    /* 
46.     * ��ʼ������ 
47.     */  
    public JavaMail() {  
        Properties props = System.getProperties();  
        props.setProperty(KEY_SMTP, VALUE_SMTP);  
        props.put(KEY_PROPS, VALUE_PROPS);  
       s = Session.getInstance(props);  
        /* s.setDebug(true);�������е�����Ϣ */  
        message = new MimeMessage(s);  
    }  
  
    /** 
58.     * �����ʼ� 
59.     *  
60.     * @param headName 
61.     *            �ʼ�ͷ�ļ��� 
62.     * @param sendHtml 
63.     *            �ʼ����� 
64.     * @param receiveUser 
65.     *            �ռ��˵�ַ 
66.     */  
    public boolean doSendHtmlEmail(String headName, String sendHtml,  
            String receiveUser) {  
    	boolean b = true;
        try {  
            // ������  
           InternetAddress from = new InternetAddress(SEND_USER);  
            message.setFrom(from);  
            // �ռ���  
            InternetAddress to = new InternetAddress(receiveUser);  
            message.setRecipient(Message.RecipientType.TO, to);  
            // �ʼ�����  
            message.setSubject(headName);  
            String content = sendHtml.toString();  
            // �ʼ�����,Ҳ����ʹ���ı�"text/plain"  
            message.setContent(content, "text/html;charset=GBK");  
            message.saveChanges();  
            Transport transport = s.getTransport("smtp");  
            // smtp��֤���������������ʼ��������û�������  
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);  
            // ����  
            transport.sendMessage(message, message.getAllRecipients());  
            transport.close();  
            System.out.println("send success!");  
        } catch (AddressException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            b=false;
        } catch (MessagingException e) {  
            e.printStackTrace();
            b=false;
        }
        return b;
    }  
   
    public static void main(String[] args) {  
        JavaMail se = new JavaMail();  
        se.doSendHtmlEmail("�ʼ�ͷ�ļ���", "�ʼ�����", "63388@qq.com"); 
    }  
  }  
