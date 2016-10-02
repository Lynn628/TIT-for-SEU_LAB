package model;

/**
 * Solutions entity. @author MyEclipse Persistence Tools
 */

public class Solutions implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nlDescription;
	private String formalDescription;
	private Integer questionId;

	// Constructors

	/** default constructor */
	public Solutions() {
	}

	/** full constructor */
	public Solutions(String nlDescription, String formalDescription,
			Integer questionId) {
		this.nlDescription = nlDescription;
		this.formalDescription = formalDescription;
		this.questionId = questionId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNlDescription() {
		return this.nlDescription;
	}

	public void setNlDescription(String nlDescription) {
		this.nlDescription = nlDescription;
	}

	public String getFormalDescription() {
		return this.formalDescription;
	}

	public void setFormalDescription(String formalDescription) {
		this.formalDescription = formalDescription;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}