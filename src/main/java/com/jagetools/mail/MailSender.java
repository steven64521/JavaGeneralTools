package com.jagetools.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送
 * 
 * @author steve
 *
 */
public class MailSender {
    private String senderName;
    private String recieverName;
    private String fromMailAcct;
    private String fromMailAcctPwd;
    private String toMailAcct;
    private String subject;
    private String textContent;
    private String mailHost;

    private static Session session;
    private static Properties properties = new Properties();

    /**
     * 
     * @param fromMailAcct    发件人邮箱账号
     * @param fromMailAcctPwd 发件人邮箱授权码或密码，推荐用授权码
     * @param mailHost        邮件服务器地址
     */
    public MailSender(String fromMailAcct, String fromMailAcctPwd, String mailHost) {
        this.fromMailAcct = fromMailAcct;
        this.fromMailAcctPwd = fromMailAcctPwd;
        this.mailHost = mailHost;
        properties.setProperty("mail.smtp.host", mailHost);
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        // 创建会话对象，用于和邮件服务器交互
        session = Session.getInstance(properties);
        session.setDebug(true);
    }

    /**
     * 发送简单文本邮件
     * 
     * @param senderName   发件人昵称
     * @param recieverName 收件人昵称
     * @param toMailAcct   收件人邮箱账号
     * @param subject      邮件主题
     * @param textContent  邮件文本内容
     */
    public void sendTextMail(String senderName, String recieverName, String toMailAcct, String subject,
            String textContent) throws Exception {
        // 创建一封邮件
        MimeMessage message = createTextMessage(senderName, recieverName, fromMailAcct, toMailAcct, subject,
                textContent);

        // 根据Session获取邮件传输对象
        Transport transport = session.getTransport();

        // 使用邮箱账号和密码连接邮件服务器，认证的邮箱必须与message中的发件人邮箱一致
        transport.connect(mailHost, fromMailAcct, fromMailAcctPwd);
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        // 关闭连接
        transport.close();
    }

    /**
     * 创建简单文本邮件
     * 
     * @param senderName
     * @param recieverName
     * @param fromMailAcct
     * @param toMailAcct
     * @param subject
     * @param textContent
     * @return
     * @throws Exception
     */
    private MimeMessage createTextMessage(String senderName, String recieverName, String fromMailAcct,
            String toMailAcct, String subject, String textContent) throws Exception {
        MimeMessage message = new MimeMessage(session);

        // 设置发件人
        message.setFrom(new InternetAddress(fromMailAcct, senderName, "UTF-8"));

        // 设置收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toMailAcct, recieverName, "UTF-8"));

        // 设置邮件主题
        message.setSubject(subject, "UTF-8");

        // 设置邮件正文
        message.setContent(textContent, "text/html;charset=UTF-8");

        // 设置发件时间
        message.setSentDate(new Date());

        // 保存设置
        message.saveChanges();
        return message;
    }

    // 测试
    public static void main(String[] args) {
        MailSender sender = new MailSender("发件人邮箱账号", "授权码", MailHost.MAILHOST_163);
        String senderName = "测试";
        String recieverName = "XX";
        String toMailAcct = "收件人邮箱账号";
        String subject = "测试";
        String textContent = "测试发送！";
        try {
            sender.sendTextMail(senderName, recieverName, toMailAcct, subject, textContent);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    public String getFromMailAcct() {
        return fromMailAcct;
    }

    public void setFromMailAcct(String fromMailAcct) {
        this.fromMailAcct = fromMailAcct;
    }

    public String getFromMailAcctPwd() {
        return fromMailAcctPwd;
    }

    public void setFromMailAcctPwd(String fromMailAcctPwd) {
        this.fromMailAcctPwd = fromMailAcctPwd;
    }

    public String getToMailAcct() {
        return toMailAcct;
    }

    public void setToMailAcct(String toMailAcct) {
        this.toMailAcct = toMailAcct;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
