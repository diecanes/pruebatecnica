package prueba.tecnica.superheroe.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Component
public class RestResponseStatusExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(
           HttpServletRequest request, 
           HttpServletResponse response, 
           Object object, 
           Exception exception) {
    	
    	if (exception instanceof NotFoundException) {
            ModelAndView model = new ModelAndView();
            model.setView(new MappingJackson2JsonView());
            model.addObject("status", "404");
            model.addObject("mensaje", exception.getMessage());
            model.setStatus(HttpStatus.NOT_FOUND);
            return model;
    	}
    	
    	if (exception instanceof DatabaseException) {
            ModelAndView model = new ModelAndView();
            model.setView(new MappingJackson2JsonView());
            model.addObject("status", "500");
            model.addObject("mensaje", exception.getMessage());
            model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return model;
    	}
    	
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject("status", "500");
        model.addObject("mensaje", "Error");
        model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return model;
    }
}
