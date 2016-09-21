package net.delight.vo;

public class ArtclVO {
	
	private int artclId; 
	private String subject; 
	private String content;
	private String createDate;
	

	public int getArtclId() {
		return artclId;
	}
	public void setArtclId(int artclId) {
		this.artclId = artclId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}