package com.just.AudioRecorder.S.Service;

import com.just.AudioRecorder.S.Dao.Bean.MailSenderInfo;
import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.SimpleMailSender;
import com.just.AudioRecorder.S.Dao.Bean.User;

public class SendEmailThread implements Runnable {
	
	private RoomBean roomBean =  new RoomBean();
	
	public SendEmailThread(RoomBean roomBean) {
		// TODO Auto-generated constructor stub
		this.roomBean.Message = roomBean.Message;
		this.roomBean.RoomMenber = roomBean.RoomMenber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String content = "";
		for(int i = 0;i < roomBean.Message.size();i++)
		{
			content = content + roomBean.Message.get(i).Content;
		}
		for(User user:roomBean.RoomMenber)
		{
			try {
				doSend(user.email, content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void doSend(String Receiver,String Content) throws Exception
	{
		MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);

        // 邮箱用户名
        mailInfo.setUserName("18362882985@163.com");
        // 邮箱密码
        mailInfo.setPassword("08111707");
        // 发件人邮箱
        mailInfo.setFromAddress("18362882985@163.com");
        // 收件人邮箱
        mailInfo.setToAddress(Receiver);

        // 邮件标题
        mailInfo.setSubject("语音记录器录制语音");
        mailInfo.setContent(Content);
        // 发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        // 发送文体格式
        sms.sendTextMail(mailInfo);
        System.out.println("邮件发送完毕");
	}

}


