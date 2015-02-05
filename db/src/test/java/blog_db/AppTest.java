package blog_db;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import blog_db.dao.BlogDAO;
import blog_db.dao.DAOException;
import blog_db.impl.Archive;
import blog_db.impl.Author;
import blog_db.impl.Category;
import blog_db.impl.Comment;
import blog_db.impl.Content;
import blog_db.impl.ViewCounter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testMapping() {
	EntityManager em =Persistence.createEntityManagerFactory("test")
				.createEntityManager();
		em.close();
	}
	
	public void testCategory(){
		
		EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();
		
		em.getTransaction().begin();
		
		BlogDAO dao = new BlogDAO(em);
		Category cat = new Category();
		
//		Content con = new Content();
//		con.setContentCore("CoreTest");
//		con.setContentURL("www.rokmeul.com/test.html");
		
		cat.setCategoryName("Photography");
//		cat.setContent(con);
		
		try {
			dao.insertOrUpdateCategory(cat);
			System.out.print("++++++++++++++++++++++++Inserted+++++++++++++++++++++++++++");
		} catch (DAOException e) {
			e.printStackTrace();
			System.out.print("------------------------ERROR------------------------------");
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void testViewCounter(){
		EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();
		
		em.getTransaction().begin();
		
		BlogDAO dao = new BlogDAO(em);
		ViewCounter vc = new ViewCounter();
		vc.setCounterUrl("www.google.com");
		vc.setCounterIp("200.140.0.123");
		
		Calendar calendar = Calendar.getInstance();
    	Date counterDate = calendar.getTime();
    	vc.setCounterDate(counterDate);
		
		try{
			dao.insertOrUpdateViewCounter(vc);
			System.out.print("++++++++++++++++++++++++Inserted+++++++++++++++++++++++++++");
		}catch (DAOException e){
			e.printStackTrace();
			System.out.print("------------------------ERROR------------------------------");
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void testAuthor(){
		EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();
		
		em.getTransaction().begin();
		
		BlogDAO dao = new BlogDAO(em);
		Author auth = new Author();
		auth.setFirstName("PHAT");
		auth.setLastName("Sereivuth");
		auth.setMail("sereivuth.phat@rokmeul.com");
		auth.setStatus("active");
		
		try{
			dao.insertOrUpdateAuthor(auth);
			System.out.print("++++++++++++++++++++++++Inserted+++++++++++++++++++++++++++");
		}catch (DAOException e){
			e.printStackTrace();
			System.out.print("------------------------ERROR------------------------------");
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void testArchive(){
		EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();
		
		em.getTransaction().begin();
		
		BlogDAO dao = new BlogDAO(em);
		Archive arc = new Archive();
		Calendar calendar = Calendar.getInstance();
    	Date archiveDate = calendar.getTime();
		arc.setArcDate(archiveDate);
		
		try{
			dao.insertOrUpdateArchive(arc);
			System.out.print("++++++++++++++++++++++++Inserted+++++++++++++++++++++++++++");
		}catch (DAOException e){
			e.printStackTrace();
			System.out.print("------------------------ERROR------------------------------");
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void testComment(){
		EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();
		
		em.getTransaction().begin();
		
		BlogDAO dao = new BlogDAO(em);
		Comment com = new Comment();
		Calendar calendar = Calendar.getInstance();
		Date commentDate = calendar.getTime();
		com.setCommentDate(commentDate);
		com.setComment("Hello Comment Test");
		com.setCommentPerson("Person TEST");
		com.setCommentIp("100.200.30.149");
		com.setCommentMail("comment.rok@rokmeul.com");
		
		try{
			dao.insertOrUpdateComment(com);
			System.out.print("++++++++++++++++++++++++Inserted+++++++++++++++++++++++++++");
		}catch (DAOException e){
			e.printStackTrace();
			System.out.print("------------------------ERROR------------------------------");
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void testContent() throws DAOException{
		EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();
		
		em.getTransaction().begin();
		
		BlogDAO dao = new BlogDAO(em);
		Content cont = new Content();
		Category cat = dao.findCategoryById(1L);
			System.out.print("-----------------category : " + cat.getCategoryName() + "\n");

		Author author = dao.findAuthorById(1L);
		System.out.print("-----------------author : " + author.getMail() + "\n");
			
		Calendar calendar = Calendar.getInstance();
		Date postDate = calendar.getTime();
		Date pubDate = calendar.getTime();
		
		cont.setOldURL("http://www.rokmeul.com/2014/12/la-fete-des-lumieres-2014.html");
		cont.setContentURL("http://www.rokmeul.com/la-fete-des-lumieres-2014.html");
		cont.setContentTitle("La fête des lumières 2014");
		cont.setContentDetail("The Festival of Lights or (French: La Fête des Lumières) is one of the most famous Festivals in France. This uniquely Lyonnaise tradition celebrated only in Lyon City, on the 8th December each year. On that day, in the night time, you will see people(Les Lyonnaises) place the candle on their windows to produce spectacular effect through the street. It\'s just like a welcome sign for the visitors that is joining this event. In the city center, a lot of lights spectacles are waiting for you. It\'s for free, more than 70 spectacles show in this 16th edition. ");
		cont.setContentCore("The Festival of Lights or (French: La Fête des Lumières) is one of the most famous Festivals in France. This uniquely Lyonnaise tradition celebrated only in Lyon City, on the 8th December each year. ");
		cont.setContentStatus("active");
		cont.setPostDate(postDate);
		cont.setPublishDate(pubDate);
		cont.setCategory(cat);
		cont.setAuthor(author);
		
		
		try{
			dao.insertOrUpdateContent(cont);
			System.out.print("++++++++++++++++++++++++Inserted+++++++++++++++++++++++++++");
		}catch (DAOException e){
			e.printStackTrace();
			System.out.print("------------------------ERROR------------------------------");
		}
		
		em.getTransaction().commit();
		em.close();		
	}
}
