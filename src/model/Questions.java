package model;

import java.util.Date;

/**
 * Questions entity. @author MyEclipse Persistence Tools
 */

public class Questions implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String answer;
	private Integer relatedQuestionId;
	private Date lastUpdateTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Questions() {
	}

	/** minimal constructor */
	public Questions(String content, Date lastUpdateTime) {
		this.content = content;
		this.lastUpdateTime = lastUpdateTime;
	}

	/** full constructor */
	public Questions(String content, String answer, Integer relatedQuestionId,
			Date lastUpdateTime, String remark) {
		this.content = content;
		this.answer = answer;
		this.relatedQuestionId = relatedQuestionId;
		this.lastUpdateTime = lastUpdateTime;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getRelatedQuestionId() {
		return this.relatedQuestionId;
	}

	public void setRelatedQuestionId(Integer relatedQuestionId) {
		this.relatedQuestionId = relatedQuestionId;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}