/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.AudioRecorder.S.Dao.Bean;

/**
 *
 * @author Administrator
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SimpleMailSender {
 
 public boolean sendTextMail(MailSenderInfo mailInfo) {
  // 鍒ゆ柇鏄惁闇�瑕佽韩浠借璇�
  MyAuthenticator authenticator = null;
  Properties pro = mailInfo.getProperties();
  if (mailInfo.isValidate()) {
   // 濡傛灉闇�瑕佽韩浠借璇侊紝鍒欏垱寤轰竴涓瘑鐮侀獙璇佸櫒
   authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
  }
  // 鏍规嵁閭欢浼氳瘽灞炴�у拰瀵嗙爜楠岃瘉鍣ㄦ瀯閫犱竴涓彂閫侀偖浠剁殑session
  Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
  try {
   // 鏍规嵁session鍒涘缓涓�涓偖浠舵秷鎭�
   Message mailMessage = new MimeMessage(sendMailSession);
   // 鍒涘缓閭欢鍙戦�佽�呭湴鍧�
   Address from = new InternetAddress(mailInfo.getFromAddress());
   // 璁剧疆閭欢娑堟伅鐨勫彂閫佽��
   mailMessage.setFrom(from);
   // 鍒涘缓閭欢鐨勬帴鏀惰�呭湴鍧�锛屽苟璁剧疆鍒伴偖浠舵秷鎭腑
   Address to = new InternetAddress(mailInfo.getToAddress());
   mailMessage.setRecipient(Message.RecipientType.TO, to);
   // 璁剧疆閭欢娑堟伅鐨勪富棰�
   mailMessage.setSubject(mailInfo.getSubject());
   // 璁剧疆閭欢娑堟伅鍙戦�佺殑鏃堕棿
   mailMessage.setSentDate(new Date());
   // 璁剧疆閭欢娑堟伅鐨勪富瑕佸唴瀹�
   String mailContent = mailInfo.getContent();
   mailMessage.setText(mailContent);
   // 鍙戦�侀偖浠�
   Transport.send(mailMessage);
   return true;
  } catch (MessagingException ex) {
   ex.printStackTrace();
  }
  return false;
 }
 
 public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
  // 鍒ゆ柇鏄惁闇�瑕佽韩浠借璇�
  MyAuthenticator authenticator = null;
  Properties pro = mailInfo.getProperties();
  // 濡傛灉闇�瑕佽韩浠借璇侊紝鍒欏垱寤轰竴涓瘑鐮侀獙璇佸櫒
  if (mailInfo.isValidate()) {
   authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
  }
  // 鏍规嵁閭欢浼氳瘽灞炴�у拰瀵嗙爜楠岃瘉鍣ㄦ瀯閫犱竴涓彂閫侀偖浠剁殑session
  Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
  try {
   // 鏍规嵁session鍒涘缓涓�涓偖浠舵秷鎭�
   Message mailMessage = new MimeMessage(sendMailSession);
   // 鍒涘缓閭欢鍙戦�佽�呭湴鍧�
   Address from = new InternetAddress(mailInfo.getFromAddress());
   // 璁剧疆閭欢娑堟伅鐨勫彂閫佽��
   mailMessage.setFrom(from);
   // 鍒涘缓閭欢鐨勬帴鏀惰�呭湴鍧�锛屽苟璁剧疆鍒伴偖浠舵秷鎭腑
   Address to = new InternetAddress(mailInfo.getToAddress());
   // Message.RecipientType.TO灞炴�ц〃绀烘帴鏀惰�呯殑绫诲瀷涓篢O
   mailMessage.setRecipient(Message.RecipientType.TO, to);
   // 璁剧疆閭欢娑堟伅鐨勪富棰�
   mailMessage.setSubject(mailInfo.getSubject());
   // 璁剧疆閭欢娑堟伅鍙戦�佺殑鏃堕棿
   mailMessage.setSentDate(new Date());
   // MiniMultipart绫绘槸涓�涓鍣ㄧ被锛屽寘鍚玀imeBodyPart绫诲瀷鐨勫璞�
   Multipart mainPart = new MimeMultipart();
   // 鍒涘缓涓�涓寘鍚獺TML鍐呭鐨凪imeBodyPart
   BodyPart html = new MimeBodyPart();
   // 璁剧疆HTML鍐呭
   html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
   mainPart.addBodyPart(html);
   // 灏哅iniMultipart瀵硅薄璁剧疆涓洪偖浠跺唴瀹�
   mailMessage.setContent(mainPart);
   // 鍙戦�侀偖浠�
   Transport.send(mailMessage);
   return true;
  } catch (MessagingException ex) {
   ex.printStackTrace();
  }
  return false;
 }
}
