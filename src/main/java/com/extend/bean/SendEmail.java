package com.extend.bean;

public class SendEmail {
	
	private String toemail;
	private String body;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	private String subject;
	private  String attachment;
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getToemail() {
		return toemail;
	}
	public void setToemail(String toemail) {
		this.toemail = toemail;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
