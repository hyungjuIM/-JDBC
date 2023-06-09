package edu.kh.jdbc.model.vo;

public class TestVO {
	private int testNo;
	private String testTitle;
	private String testContent;
	
	// 컨트롤 스페이스
	// 기본생성자
	public TestVO() {
	}

	// alt shift +s+o
	// 매개변수 생성자
	public TestVO(int testNo, String testTitle, String testContent) {
		super();
		this.testNo = testNo;
		this.testTitle = testTitle;
		this.testContent = testContent;
	}
	
	// alt shift s r > (전체선택) > generate


	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}
	
	// alt shift s generate to String()
	@Override
	public String toString() {
		return "TestVO [testNo=" + testNo + ", testTitle=" + testTitle + ", testContent=" + testContent + "]";
	}
	
	
	
}
