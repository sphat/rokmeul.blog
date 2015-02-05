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

import blog_db.intf.Iauthor;

/**
 * @author psph-linux
 *
 */
@Entity
@Table(name = "author")
@XmlRootElement(name = "author", namespace="http://www.rokmeul.com/blog_db/impl/author")
@XmlAccessorType(XmlAccessType.FIELD)
public class Author implements Iauthor {
	
	@Id
	@GeneratedValue
	@Column(name = "aid")
	@XmlElement(name = "aid")
	private Long Aid;
	
	@Column(name = "first_name")
	@XmlElement(name = "first_name")
	private String FirstName;
	
	@Column(name = "last_name")
	@XmlElement(name = "last_name")
	private String LastName;
	
	@Column(name = "mail")
	@XmlElement(name = "mail")
	private String Mail;
	
	@Column(name = "status")
	@XmlElement(name = "status")
	private String Status;
	
	@OneToMany(mappedBy = "author")
	@XmlElement(name = "content")
	private List<Content> contents = new ArrayList<Content>();
	
	public Collection<Content> getContents() {
		return contents;
	}
	
	void removeContent(Content aThis) {
		contents.remove(aThis);
	}

	void addContent(Content aThis) {
		contents.add(aThis);
	}
	
	/**
	 * @param aid the aid to set
	 */
	public void setAid(Long aid) {
		this.Aid = aid;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.Mail = mail;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.Status = status;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iauthor#getAid()
	 */
	@Override
	public Long getAid() {
		return Aid;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iauthor#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return FirstName;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iauthor#getLastName()
	 */
	@Override
	public String getLastName() {
		return LastName;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iauthor#getMail()
	 */
	@Override
	public String getMail() {
		return Mail;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iauthor#getStatus()
	 */
	@Override
	public String getStatus() {
		return Status;
	}

}
