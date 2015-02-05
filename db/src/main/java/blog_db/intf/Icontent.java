/**
 * 
 */
package blog_db.intf;

import java.util.Date;

/**
 * @author psph-linux
 *
 */
public interface Icontent {
	
	Long getContentId();
	
	//Long getCategoryId();

	String getContentURL();
	
	String getOldURL();
	
	String getContentTitle();
	
	String getContentCore();
	
	String getContentDetail();
	
	String getContentStatus();
	
	Date getPostDate();
	
	Date getPublishDate();

}
