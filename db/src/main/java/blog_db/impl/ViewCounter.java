/**
 * 
 */
package blog_db.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import blog_db.intf.Iview_counter;

/**
 * @author psph-linux
 *
 */
@Entity
@Table(name = "view_counter")
@XmlRootElement(name = "view_counter", namespace="http://www.rokmeul.com/blog_db/impl/view_counter")
@XmlAccessorType(XmlAccessType.FIELD)
public class ViewCounter implements Iview_counter {
	
	@Id
	@GeneratedValue
	@Column(name = "counter_id")
	@XmlElement(name = "counter_id")
	private Long CounterId;
	
	@Column(name = "counter_url")
	@XmlElement(name = "counter_url")
	private String CounterUrl;
	
	@Column(name = "counter_ip")
	@XmlElement(name = "counter_ip")
	private String CounterIp;
	
	@Column(name = "counter_date")
	@XmlElement(name = "counter_date")
	private Date CounterDate;

	/**
	 * @param counterId the counterId to set
	 */
	public void setCounterId(Long counterId) {
		CounterId = counterId;
	}

	/**
	 * @param counterUrl the counterUrl to set
	 */
	public void setCounterUrl(String counterUrl) {
		CounterUrl = counterUrl;
	}

	/**
	 * @param counterIp the counterIp to set
	 */
	public void setCounterIp(String counterIp) {
		CounterIp = counterIp;
	}

	/**
	 * @param counterDate the counterDate to set
	 */
	public void setCounterDate(Date counterDate) {
		CounterDate = counterDate;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iview_counter#getCounterId()
	 */
	@Override
	public Long getCounterId() {
		return CounterId;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iview_counter#getCounterUrl()
	 */
	@Override
	public String getCounterUrl() {
		return CounterUrl;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iview_counter#getCounterIp()
	 */
	@Override
	public String getCounterIp() {
		return CounterIp;
	}

	/* (non-Javadoc)
	 * @see blog_db.intf.Iview_counter#getCounterDate()
	 */
	@Override
	public Date getCounterDate() {
		return CounterDate;
	}

}
