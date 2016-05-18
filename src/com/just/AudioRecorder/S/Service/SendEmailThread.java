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

        // �����û���
        mailInfo.setUserName("18362882985@163.com");
        // ��������
        mailInfo.setPassword("08111707");
        // ����������
        mailInfo.setFromAddress("18362882985@163.com");
        // �ռ�������
        mailInfo.setToAddress(Receiver);

        // �ʼ�����
        mailInfo.setSubject("������¼��¼������");
        mailInfo.setContent(Content);
        // �����ʼ�
        SimpleMailSender sms = new SimpleMailSender();
        // ���������ʽ
        sms.sendTextMail(mailInfo);
        System.out.println("�ʼ��������");
	}

}


