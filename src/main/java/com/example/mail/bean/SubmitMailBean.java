package com.example.mail.bean;

import java.io.Serializable;


public class SubmitMailBean implements Serializable{
	// 送信先アドレス
	private String address;

	// タイトル
	private String subject;

	// 本文
	private String mailBody;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}



}