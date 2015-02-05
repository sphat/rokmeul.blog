/**
 * 
 */
package blog_db.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import blog_db.intf.Iarchive;

/**
 * @author psph-linux
 *
 */
@Entity
@Table(name = "archive")
@XmlRootElement(name = "archive", namespace="http://www.rokmeul.com/blog_db/impl/archive")
@XmlAccessorType(XmlAccessType.FIELD)
public class Archive implements Iarchive {

	@Id
	@GeneratedValue
	@Column(name = "archive_id")
	@XmlElement(name = "archive_id")
	private Long ArcId;
	
	@Column(name = "archive_date")
	@XmlElement(name = "archive_date")
	private Date ArcDate;
	
	/**
	 * @param arcId the arcId to set
	 */
	public void setArcId(Long arcId) {
		ArcId = arcId;
	}

	/**
	 * @param arcDate the arcDate to set
	 */
	public void setArcDate(Date arcDate) {
		ArcDate = arcDate;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iarchive#getArcId()
	 */
	@Override
	public Long getArcId() {
		return ArcId;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iarchive#getArcDate()
	 */
	@Override
	public Date getArcDate() {
		return ArcDate;
	}

}
