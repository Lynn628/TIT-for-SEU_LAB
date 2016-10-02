package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AtomKnowledges entity. @author MyEclipse Persistence Tools
 */

public class AtomKnowledges implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nlDescription;
	private String formalDescription;
	private Integer type;
	private String source;
	private Date lastUpdateTime;
	private Set questionAtomKnowledges = new HashSet(0);

	// Constructors

	/** default constructor */
	public AtomKnowledges() {
	}

	/** minimal constructor */
	public AtomKnowledges(String nlDescription, String formalDescription,
			Integer type, String source, Date lastUpdateTime) {
		this.nlDescription = nlDescription;
		this.formalDescription = formalDescription;
		this.type = type;
		this.source = source;
		this.lastUpdateTime = lastUpdateTime;
	}

	/** full constructor */
	public AtomKnowledges(String nlDescription, String formalDescription,
			Integer type, String source, Date lastUpdateTime,
			Set questionAtomKnowledges) {
		this.nlDescription = nlDescription;
		this.formalDescription = formalDescription;
		this.type = type;
		this.source = source;
		this.lastUpdateTime = lastUpdateTime;
		this.questionAtomKnowledges = questionAtomKnowledges;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set getQuestionAtomKnowledges() {
		return this.questionAtomKnowledges;
	}

	public void setQuestionAtomKnowledges(Set questionAtomKnowledges) {
		this.questionAtomKnowledges = questionAtomKnowledges;
	}

}