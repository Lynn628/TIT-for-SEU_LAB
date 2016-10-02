package model;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer parentId;
	private Boolean isLeaf;

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(String name, Integer parentId, Boolean isLeaf) {
		this.name = name;
		this.parentId = parentId;
		this.isLeaf = isLeaf;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Boolean getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}