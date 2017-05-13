/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.controller;

import com.infodev.fcgorole.dao.DonorDao;
import com.infodev.fcgorole.dao.EconomicDao;
import com.infodev.fcgorole.dao.PoDao;
import com.infodev.fcgorole.dao.ProjectDao;
import com.infodev.fcgorole.dao.SourceTypeDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mansubh
 */
@Controller
public class MainController {
    
    @Autowired
    private PoDao poDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private EconomicDao economicDao;
    @Autowired
    private SourceTypeDao sourceTypeDao;
    @Autowired
    private DonorDao donorDao;
    
    
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("Allpos", poDao.getByDistrictCode("27"));
                model.addObject("Alldonor", donorDao.getAll());
                model.addObject("Allproject", projectDao.getAll());
                model.addObject("Allsourcetype", sourceTypeDao.getAll());
                model.addObject("Alleconomic", economicDao.getAll());
		model.setViewName("admin");

		return model;

	}
        
        @RequestMapping(value = "/po**", method = RequestMethod.GET)
	public ModelAndView poPage() {

		ModelAndView model = new ModelAndView();
		 model.addObject("Alldonor", donorDao.getAll());
                model.addObject("Allproject", projectDao.getAll());
                model.addObject("Allsourcetype", sourceTypeDao.getAll());
                model.addObject("Alleconomic", economicDao.getAll());
		model.setViewName("hello");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
    
}
