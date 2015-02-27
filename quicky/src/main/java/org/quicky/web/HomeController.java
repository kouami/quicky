/**
 * 
 */
package org.quicky.web;

import org.quicky.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Emmanuel
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value={"/","/index"})
	public String home(){
		return "index";
	}
}
