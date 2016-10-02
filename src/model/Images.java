package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Images entity. @author MyEclipse Persistence Tools
 */

public class Images implements java.io.Serializable {

	// Fields

	private Integer id;
	private byte[] img;
	private Set questionImages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Images() {
	}

	/** minimal constructor */
	public Images(byte[] img) {
		this.img = img;
	}

	/** full constructor */
	public Images(byte[] img, Set questionImages) {
		this.img = img;
		this.questionImages = questionImages;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getImg() {
		return this.img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Set getQuestionImages() {
		return this.questionImages;
	}

	public void setQuestionImages(Set questionImages) {
		this.questionImages = questionImages;
	}

}