package model;

import java.util.ArrayList;

public class OverviewModel {
	private int queId;
	private String content;
	private ArrayList<String> question_type;
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(ArrayList<String> question_type) {
		this.question_type = question_type;
	}
}
