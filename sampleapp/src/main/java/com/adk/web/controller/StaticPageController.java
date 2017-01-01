package com.adk.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class StaticPageController extends MultiActionController{

	
	@RequestMapping("/tabletenniscoimbatore/centers")
	public ModelAndView centers(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/centers");

	}
	
	@RequestMapping("/tabletenniscoimbatore/adk")
	public ModelAndView adk(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/location_adk");

	}
	
	@RequestMapping("/tabletenniscoimbatore/cdtta")
	public ModelAndView cdtta(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/location_cdtta");

	}
	
	@RequestMapping("/tabletenniscoimbatore/psg")
	public ModelAndView psg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/location_psg");

	}
	
	@RequestMapping("/tabletenniscoimbatore/spott")
	public ModelAndView spott(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/location_spott");

	}
	
	@RequestMapping("/tabletenniscoimbatore/srivari")
	public ModelAndView srivari(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/location_srivari");

	}
	
	@RequestMapping("/tabletenniscoimbatore/home")
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("index");

	}
	
	@RequestMapping("/tabletenniscoimbatore/photos")
	public ModelAndView photos(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/photogallery");

	}
	
	
	@RequestMapping("/tabletenniscoimbatore/certification")
	public ModelAndView certification(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			return new ModelAndView("pages/certification");

	}
	
}