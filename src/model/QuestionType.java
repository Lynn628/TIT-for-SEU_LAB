package model;

/**
 * QuestionType entity. @author MyEclipse Persistence Tools
 */

public class QuestionType implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questions questions;
	private Integer typeId;

	// Constructors

	/** default constructor */
	public QuestionType() {
	}

	/** full constructor */
	public QuestionType(Questions questions, Integer typeId) {
		this.questions = questions;
		this.typeId = typeId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}