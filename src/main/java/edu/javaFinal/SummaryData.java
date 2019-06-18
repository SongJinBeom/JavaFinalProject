package edu.javaFinal;

public class SummaryData {

	private String fileNum;
	private String title;
	private String summary;
	private String keyword;
	private String openDate;
	private String weblink;
	private String sourceSite;
	private String copyright;
	private String fullInfo;
	// String category2 = "제목(반드시 요약문 양식에 입력한 제목과 같아야함.), 표/그림 일련번호, 자료유형(표,그림...),
	// " + "자료에 나온 표나 그림 설명(캡션), 자료가 나온 쪽번호";

	public SummaryData(String info, String key) {
		String[] temp = new String[7];
	
		for(int i = 0; i<temp.length;i++) {
			if(temp[i]==null) {
				temp[i]= "";
			}
		}
		
		temp = info.split(",");
		this.fileNum = key;
		this.title = temp[0];
		this.summary = temp[1];
		this.keyword = temp[2];
		this.openDate = temp[3];
		this.weblink = temp[4];
		this.sourceSite = temp[5];
		this.copyright = temp[6];
		this.fullInfo = merge();
		
	}

	public String merge() {
		String info = this.fileNum + "," + this.title + "," + this.summary + "," + this.keyword + "," + this.openDate
				+ "," + this.weblink + "," + this.sourceSite + "," + this.copyright;

		return info;
	}

	public String getFullInfo() {
		return fullInfo;
	}

	public void setFullInfo(String fullInfo) {
		this.fullInfo = fullInfo;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getWeblink() {
		return weblink;
	}

	public void setWeblink(String weblink) {
		this.weblink = weblink;
	}

	public String getSourceSite() {
		return sourceSite;
	}

	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

}
