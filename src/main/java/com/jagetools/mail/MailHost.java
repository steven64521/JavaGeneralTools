package com.jagetools.mail;

/**
 * 常用邮箱的smtp服务器地址 未开启SSL的话，默认端口为25，要使用smtp/pop3等，必须先开启该功能，否则发送不出去
 * 
 * @author steve
 *
 */
public class MailHost {

    // 网易163邮箱服务器地址和端口号
    public static final String MAILHOST_163 = "smtp.163.com";
    public static final String MAILHOSTPORT_163 = "25";

    // Tencent QQ邮箱服务器地址和端口号
    public static final String MAILHOST_QQ = "smtp.qq.com";
    public static final String MAILHOSTPORT_QQ = "25";

    // Gmail邮箱服务器地址和端口号
    public static final String MAILHOST_GMAIL = "smtp.gmail.com";
    public static final String MAILHOSTPORT_GMAIL_SSL = "587";

    // 网易126邮箱服务器地址和端口号
    public static final String MAILHOST_126 = "smtp.126.com";
    public static final String MAILHOSTPORT_126 = "25";

    // 139邮箱服务器地址和端口号
    public static final String MAILHOST_139 = "SMTP.139.com";
    public static final String MAILHOSTPORT_139 = "25";

    // 新浪（sina.com）邮箱服务器地址和端口号
    public static final String MAILHOST_SINA = "smtp.sina.com.cn";
    public static final String MAILHOSTPORT_SINA = "25";
}
