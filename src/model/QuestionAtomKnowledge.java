package model;

/**
 * QuestionAtomKnowledge entity. @author MyEclipse Persistence Tools
 */

public class QuestionAtomKnowledge implements java.io.Serializable {

	// Fields

	private Integer id;
	private AtomKnowledges atomKnowledges;
	private Integer questionId;

	// Constructors

	/** default constructor */
	public QuestionAtomKnowledge() {
	}

	/** full constructor */
	public QuestionAtomKnowledge(AtomKnowledges atomKnowledges,
			Integer questionId) {
		this.atomKnowledges = atomKnowledges;
		this.questionId = questionId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AtomKnowledges getAtomKnowledges() {
		return this.atomKnowledges;
	}

	public void setAtomKnowledges(AtomKnowledges atomKnowledges) {
		this.atomKnowledges = atomKnowledges;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}