package neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import neo.pojo.Department;
import neo.server.DepaSv;

@Controller
@RequestMapping("/depa")
public class DepaWeb {
	
	@Autowired
	private DepaSv depaSv ;
	
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView mav=new ModelAndView();
		
		List<Department> list;
		
		list = depaSv.findList();
		
		mav.addObject("depaList", list);
		
		mav.addObject("actionName", "部门管理");
		mav.addObject("mainPage", "depa/list.jsp");
		mav.setViewName("index");
		
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		Department depa = depaSv.findById(Integer.parseInt(id));
		mav.addObject("depa", depa);
		mav.setViewName("depa/save");
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@RequestParam(value="id",required=false)String id,Department depa){
		ModelAndView mav=new ModelAndView();
		depaSv.update(depa);
		mav.setViewName("depa/ok");
		return mav;
	}

}
