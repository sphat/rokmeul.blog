/**
 * 
 */
package blog_db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import blog_db.impl.Archive;
import blog_db.impl.Author;
import blog_db.impl.Category;
import blog_db.impl.Comment;
import blog_db.impl.Content;
import blog_db.impl.ViewCounter;
import blog_db.intf.Iarchive;
import blog_db.intf.Iauthor;
import blog_db.intf.Icategory;
import blog_db.intf.Icomment;
import blog_db.intf.Icontent;
import blog_db.intf.Iview_counter;

/**
 * @author psph-linux
 *
 */
@Component
public class BlogDAO {
	
	@PersistenceContext 
	private EntityManager em;
	
	private EntityManagerFactory emf;
	
	private static Query query;
	
	public BlogDAO(){
		
	}
	
	public BlogDAO(EntityManager em_ref){
		em = em_ref;
	}
	
	public EntityManagerFactory getEmf() {
		return this.emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
		em = emf.createEntityManager();
	}

	public void setEntityManager(EntityManager em_ref) {
		em = em_ref;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertOrUpdateCategory(Icategory category) throws DAOException{
		try{
			Category cat = (Category) category;
			if(cat.getCategoryId()  != null  && em.find(Category.class, cat.getCategoryId()) != null){
				em.merge(cat);
			}else{
				em.persist(cat);
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public Category findCategoryById(Long category_id) throws DAOException{
		StringBuffer str_sql = new StringBuffer();
		str_sql.append("SELECT ");
		str_sql.append("cat ");
		str_sql.append("FROM ");
		str_sql.append("blog_db.impl.Category").append(" cat ");
		str_sql.append("WHERE ");
		str_sql.append("cat.CategoryId =:category_id");
		query = em.createQuery(str_sql.toString());
		query.setParameter("category_id", category_id);
		
		List<Category> cat = query.getResultList();

		if (cat.size() > 0) {
			return cat.get(0);
		}
		
		return null;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public Author findAuthorById(Long author_id) throws DAOException{
		StringBuffer str_sql = new StringBuffer();
		str_sql.append("SELECT ");
		str_sql.append("author ");
		str_sql.append("FROM ");
		str_sql.append("blog_db.impl.Author").append(" author ");
		str_sql.append("WHERE ");
		str_sql.append("author.Aid =:author_id");
		query = em.createQuery(str_sql.toString());
		query.setParameter("author_id", author_id);
		
		List<Author> author = query.getResultList();

		if (author.size() > 0) {
			return author.get(0);
		}
		
		return null;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertOrUpdateViewCounter(Iview_counter view_counter) throws DAOException{
		try{
			ViewCounter vc = (ViewCounter) view_counter;
			if(vc.getCounterId() != null && em.find(ViewCounter.class, vc.getCounterId()) != null){
				em.merge(vc);
			}else{
				em.persist(vc);
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertOrUpdateAuthor(Iauthor author) throws DAOException{
		try{
			Author auth = (Author) author;
			if(auth.getAid() != null && em.find(Author.class, auth.getAid()) != null){
				em.merge(auth);
			}else{
				em.persist(auth);
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertOrUpdateArchive(Iarchive archive) throws DAOException{
		try{
			Archive arc = (Archive) archive;
			if(arc.getArcId() != null && em.find(Archive.class, arc.getArcId()) != null){
				em.merge(arc);
			}else{
				em.persist(arc);
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertOrUpdateComment(Icomment comment) throws DAOException{
		try{
			Comment com = (Comment) comment;
			if(com.getCommentID() != null && em.find(Comment.class, com.getCommentID()) != null){
				em.merge(com);
			}else{
				em.persist(com);
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertOrUpdateContent(Icontent content) throws DAOException{
		try{
			Content cont = (Content) content;
			if(cont.getContentId() != null && em.find(Content.class, cont.getContentId()) != null){
				em.merge(cont);
			}else{
				em.persist(cont);
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
}
