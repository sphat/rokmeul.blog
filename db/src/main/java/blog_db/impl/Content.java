/**
 * 
 */
package blog_db.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import blog_db.intf.Iauthor;
import blog_db.intf.Icategory;
import blog_db.intf.Icontent;

/**
 * @author psph-linux
 *
 */
@Entity
@Table(name = "content")
@XmlRootElement(name = "content", namespace="http://www.rokmeul.com/blog_db/impl/content")
@XmlAccessorType(XmlAccessType.FIELD)
public class Content implements Icontent {

	@Id
	@GeneratedValue
	@Column(name = "content_id")
	@XmlElement(name = "content_id")
	private Long ContentId;
	
	@Column(name = "content_rul")
	@XmlElement(name = "content_url")
	private String ContentURL;
	
	@Column(name = "content_old_rul")
	@XmlElement(name = "content_old_url")
	private String OldURL;
	
	@Column(name = "content_title")
	@XmlElement(name = "content_title")
	private String ContentTitle;
	
	@Column(name = "content_core", length = 65535, columnDefinition="Text")
	@XmlElement(name = "content_core")
	private String ContentCore;
	
	@Column(name = "content_detail", length = 65535, columnDefinition="Text")
	@XmlElement(name = "content_detail")
	private String ContentDetail;
	
	@Column(name = "content_status")
	@XmlElement(name = "content_status")
	private String ContentStatus;
	
	@Column(name = "post_date")
	@XmlElement(name = "post_date")
	private Date PostDate;
	
	@Column(name = "publish_date")
	@XmlElement(name = "publish_date")
	private Date PublishDate;
	
	@OneToMany(mappedBy = "content")
	@XmlElement(name = "comment")
	private List<Comment> comments = new ArrayList<Comment>();
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "author")
	private Author author;
	
	public Collection<Comment> getComments() {
		return comments;
	}
	
	void removeComment(Comment aThis) {
		comments.remove(aThis);
	}

	void addComment(Comment aThis) {
		comments.add(aThis);
	}
	
	public Iauthor getAuthor(){
		return author;
	}
	
	public void setAuthor(Author author){
		if (this.author != null) {
			this.author.removeContent(this);
		}
		this.author = author;
		author.addContent(this);
	}
	
	public Icategory getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		if (this.category != null) {
			this.category.removeContent(this);
		}
		this.category = category;
		category.addContent(this);
	}
	
	/**
	 * @param contentId the contentId to set
	 */
	public void setContentId(Long contentId) {
		ContentId = contentId;
	}

	/**
	 * @param contentURL the contentURL to set
	 */
	public void setContentURL(String contentURL) {
		ContentURL = contentURL;
	}

	/**
	 * @param contentTitle the contentTitle to set
	 */
	public void setContentTitle(String contentTitle) {
		ContentTitle = contentTitle;
	}

	/**
	 * @param contentCore the contentCore to set
	 */
	public void setContentCore(String contentCore) {
		ContentCore = contentCore;
	}

	/**
	 * @param contentDetail the contentDetail to set
	 */
	public void setContentDetail(String contentDetail) {
		ContentDetail = contentDetail;
	}

	/**
	 * @param contentStatus the contentStatus to set
	 */
	public void setContentStatus(String contentStatus) {
		ContentStatus = contentStatus;
	}

	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getContentId()
	 */
	@Override
	public Long getContentId() {
		return ContentId;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getContentURL()
	 */
	@Override
	public String getContentURL() {
		return ContentURL;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getContentTitle()
	 */
	@Override
	public String getContentTitle() {
		return ContentTitle;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getContentCore()
	 */
	@Override
	public String getContentCore() {
		return ContentCore;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getContentDetail()
	 */
	@Override
	public String getContentDetail() {
		return ContentDetail;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getContentStatus()
	 */
	@Override
	public String getContentStatus() {
		return ContentStatus;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getPostDate()
	 */
	@Override
	public Date getPostDate() {
		return PostDate;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icontent#getPublishDate()
	 */
	@Override
	public Date getPublishDate() {
		return PublishDate;
	}

	@Override
	public String getOldURL() {
		return OldURL;
	}

	/**
	 * @param oldURL the oldURL to set
	 */
	public void setOldURL(String oldURL) {
		OldURL = oldURL;
	}
	
}
