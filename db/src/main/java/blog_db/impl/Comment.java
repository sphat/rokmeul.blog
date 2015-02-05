/**
 * 
 */
package blog_db.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import blog_db.intf.Icomment;
import blog_db.intf.Icontent;

/**
 * @author psph-linux
 *
 */
@Entity
@Table(name = "comment")
@XmlRootElement(name = "comment", namespace="http://www.rokmeul.com/blog_db/impl/comment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comment implements Icomment {

	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	@XmlElement(name = "comment_id")
	private Long CommentID;
	
	@Column(name = "comment_date")
	@XmlElement(name = "comment_date")
	private Date CommentDate;
	
	@Column(name = "comment", length = 1024)
	@XmlElement(name = "comment")
	private String Comment;
	
	@Column(name = "comment_person")
	@XmlElement(name = "comment_person")
	private String CommentPerson;
	
	@Column(name = "comment_mail")
	@XmlElement(name = "comment_mail")
	private String CommentMail;
	
	@Column(name = "comment_ip")
	@XmlElement(name = "comment_ip")
	private String CommentIp;
	
	@ManyToOne
	@JoinColumn(name = "content")
	private Content content;
	
	public Icontent getContent(){
		return content;
	}
	
	public void setContent(Content content){
		if (this.content != null) {
			this.content.removeComment(this);
		}
		this.content = content;
		content.addComment(this);
	}
	
	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(Long commentID) {
		CommentID = commentID;
	}

	/**
	 * @param commentDate the commentDate to set
	 */
	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		Comment = comment;
	}

	/**
	 * @param commentPerson the commentPerson to set
	 */
	public void setCommentPerson(String commentPerson) {
		CommentPerson = commentPerson;
	}

	/**
	 * @param commentMail the commentMail to set
	 */
	public void setCommentMail(String commentMail) {
		CommentMail = commentMail;
	}

	/**
	 * @param commentIp the commentIp to set
	 */
	public void setCommentIp(String commentIp) {
		CommentIp = commentIp;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icomment#getCommentID()
	 */
	@Override
	public Long getCommentID() {
		return CommentID;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icomment#getCommentDate()
	 */
	@Override
	public Date getCommentDate() {
		return CommentDate;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icomment#getComment()
	 */
	@Override
	public String getComment() {
		return Comment;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icomment#getCommentPerson()
	 */
	@Override
	public String getCommentPerson() {
		return CommentPerson;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icomment#getCommentMail()
	 */
	@Override
	public String getCommentMail() {
		return CommentMail;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Icomment#getCommentIp()
	 */
	@Override
	public String getCommentIp() {
		return CommentIp;
	}

}
