/**
 * 
 */
package blog_db.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import blog_db.intf.Icategory;

/**
 * @author psph-linux
 *
 */
@Entity
@Table(name = "category")
@XmlRootElement(name = "category", namespace="http://www.rokmeul.com/blog_db/impl/category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category implements Icategory {
	
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	@XmlElement(name = "category_id")
	private Long CategoryId;
	
	@Column(name = "category_name")
	@XmlElement(name = "category_name")
	private String CategoryName;
	
	@OneToMany(mappedBy = "category")
	@XmlElement(name = "content")
	private List<Content> contents = new ArrayList<Content>();

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icategory#getCategoryId()
	 */
	@Override
	public Long getCategoryId() {
		return CategoryId;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icategory#getCategoryName()
	 */
	@Override
	public String getCategoryName() {
		return CategoryName;
	}

	public Collection<Content> getContents() {
		return contents;
	}
	
	void removeContent(Content aThis) {
		contents.remove(aThis);
	}

	void addContent(Content aThis) {
		contents.add(aThis);
	}

}
