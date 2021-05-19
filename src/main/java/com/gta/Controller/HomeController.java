package com.gta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gta.Entity.*;
import com.gta.Repo.CategoryRepo;
import com.gta.Repo.QaaRepo;

@Controller
public class HomeController {

	String licategory=null;
	List<Qaa> selCatList=null;
	
	 ModelAndView modelAndView=new ModelAndView();
	
	@Autowired
	private CategoryRepo repo;
	
	@Autowired
	private QaaRepo repo1;
	
	@Autowired
	CategoryRepo fetchDataService;
	
	@Autowired
	QaaRepo fetchDataService1;
	
	@GetMapping("")
	public String index(ModelMap  Model) {
		
		List<Category> cat = fetchDataService.findAll();
		
		Model.addAttribute("category",cat);	
		licategory=fetchDataService.findAll().toString();
		Model.addAttribute("Cate",licategory);
		int i=0;
		for (Category category : cat) {
			System.out.println(cat.get(i).getCategoryName());
			i++;
		}
		
		
		return "index";
	}
	@GetMapping("/faq")
	public String faq(ModelMap  Model) {
List<Category> cat = fetchDataService.findAll();
List<Qaa> qaa=fetchDataService1.findAll();
		
		Model.addAttribute("category",cat);	
		Model.addAttribute("qaa",qaa);	
		
		licategory=fetchDataService.findAll().toString();
		Model.addAttribute("Cate",licategory);
		int i=0;
		for (Category category : cat) {
			System.out.println(cat.get(i).getCategoryName());
			i++;
		}
		return "faq";
	}
	
//	Add Category Start
	@RequestMapping("/add_Category" )
	public String addCategory(@RequestParam("cat") String cat) {
		Category category= new Category();
		category.setCategoryName(cat);
		repo.save(category);
//		modelAndView.setViewName("redirect:faq");
//		modelAndView.addObject(category,category);)
		
		return "redirect:faq";
	}
//	Add Category End
	
	
//	Add Qaa Start
	@RequestMapping("/add_Qaa" )
	public String addQaa(@RequestParam("category") Long cat, @RequestParam("qes") String qes,@RequestParam("ans") String ans,@RequestParam("ac") String ac) {
		Category category= repo.getOne(cat);
		Qaa qaa1= new Qaa();
		qaa1.setRefId(category.getCatid());
		qaa1.setQuestion(qes);
		qaa1.setAnswer(ans);
		qaa1.setAction(ac);
		
		if(qaa1.getAnswer().toString()==null || qaa1.getAnswer().toString()=="") {
			qaa1.setAnswer("None");
		}
		if(qaa1.getQuestion().toString()==null || qaa1.getQuestion().toString()=="") {
			qaa1.setQuestion("None");
		}
		if(qaa1.getAction().toString()==null || qaa1.getAction().toString()=="") {
			qaa1.setAction("None");
		}
		
		repo1.save(qaa1);
//		modelAndView.setViewName("redirect:faq");
//		modelAndView.addObject(category,category);)
		
		return "redirect:faq";
	}
//	Add Qaa End
		
	
	
	@GetMapping("/test")
	public String test(ModelMap  Model) {
List<Category> cat = fetchDataService.findAll();
		
		Model.addAttribute("category",cat);	
		licategory=fetchDataService.findAll().toString();
		Model.addAttribute("Cate",licategory);
		int i=0;
		for (Category category : cat) {
			System.out.println(cat.get(i).getCategoryName());
			i++;
		}
		return "test";
	}
	
	

	
	@RequestMapping("/del_Category" )
	public String delCategory(@RequestParam("category") Long cat) {
		Category category= repo.getOne(cat);
//		category.setCategoryName(delcat);
		repo.delete(category);
//		modelAndView.setViewName("redirect:faq");
//		modelAndView.addObject(category,category);)
		
		return "redirect:faq";
	}
	
	@RequestMapping("/sel_Category" )
	public String selCategory(@RequestParam("category") Long cat) {
		Category category= repo.getOne(cat);
		selCatList=fetchDataService1.findByRefId(category.getCatid());
//		category.setCategoryName(delcat);
		int i=0;
		for (Qaa q : selCatList) {
			System.out.println(q.getQuestion());
			i++;
		}
//		modelAndView.setViewName("redirect:faq");
//		modelAndView.addObject(category,category);)
		
		return "redirect:faq";
	}
	
}
