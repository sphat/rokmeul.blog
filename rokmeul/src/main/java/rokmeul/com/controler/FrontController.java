/**
 * 
 */
package rokmeul.com.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author root
 *
 */
public class FrontController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView modelandview = new ModelAndView("index");
		modelandview.addObject("welcome message", "Welcome to rokmel with Spring MVC Framework !");
		
		return modelandview;
	}

}
