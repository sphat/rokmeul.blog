/**
 * 
 */
package blog_db.intf;

import java.util.Date;

/**
 * @author psph-linux
 *
 */
public interface Icomment {
	
	Long getCommentID();
	
	Date getCommentDate();
	
	String getComment();
	
	String getCommentPerson();
	
	String getCommentMail();
	
	String getCommentIp();

}
