/**
 * 
 */
package blog_db.intf;

import java.util.Date;

/**
 * @author psph-linux
 *
 */
public interface Iview_counter {

	Long getCounterId();
	
	String getCounterUrl();
	
	String getCounterIp();
	
	Date getCounterDate();
	
}
