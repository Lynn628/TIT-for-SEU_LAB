package model;

import java.util.ArrayList;

public class OutputModel {
	private ArrayList<String> question_type;
	private ArrayList<byte[]> img;
	private Questions question;
	private ArrayList<AtomKnowledges> atom;
	private ArrayList<Solutions> solution;
	public ArrayList<String> getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(ArrayList<String> question_type) {
		this.question_type = question_type;
	}
	public ArrayList<byte[]> getImg() {
		return img;
	}
	public void setImg(ArrayList<byte[]> img) {
		this.img = img;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public ArrayList<AtomKnowledges> getAtom() {
		return atom;
	}
	public void setAtom(ArrayList<AtomKnowledges> atom) {
		this.atom = atom;
	}
	public ArrayList<Solutions> getSolution() {
		return solution;
	}
	public void setSolution(ArrayList<Solutions> solution) {
		this.solution = solution;
	}

}
