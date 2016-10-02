package model;

/**
 * QuestionImage entity. @author MyEclipse Persistence Tools
 */

public class QuestionImage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Images images;
	private Integer questionId;

	// Constructors

	/** default constructor */
	public QuestionImage() {
	}

	/** full constructor */
	public QuestionImage(Images images, Integer questionId) {
		this.images = images;
		this.questionId = questionId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Images getImages() {
		return this.images;
	}

	public void setImages(Images images) {
		this.images = images;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}