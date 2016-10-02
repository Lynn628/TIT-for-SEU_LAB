package model;

import java.util.ArrayList;

public class InputModel {
	private ArrayList<Integer> question_type;
	private ArrayList<String> img;
	private Questions question;
	private ArrayList<AtomKnowledges> atom;
	private ArrayList<Solutions> solution;
	public ArrayList<Integer> getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(ArrayList<Integer> question_type) {
		this.question_type = question_type;
	}
	public ArrayList<String> getImg() {
		return img;
	}
	public void setImg(ArrayList<String> img) {
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
