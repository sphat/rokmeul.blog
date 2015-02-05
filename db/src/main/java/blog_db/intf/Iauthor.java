/**
 * 
 */
package blog_db.intf;

/**
 * @author psph-linux
 *
 */
public interface Iauthor {

	/**
	 * Get Author ID
	 * @return Author ID
	 */
	Long getAid();
	
	/**
	 * Get Author First Name
	 * @return Author First Name
	 */
	String getFirstName();
	
	/**
	 * Get Author Last Name
	 * @return Author Last Name
	 */
	String getLastName();
	
	/**
	 * Get Author Mail
	 * @return Author Mail
	 */
	String getMail();
	
	/**
	 * Get Author Status
	 * @return Author Status 
	 */
	String getStatus();
	
}
