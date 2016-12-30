package neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import neo.pojo.Staff;
import neo.server.StaffSv;
import neo.unit.StringUtil;

@Controller
@RequestMapping("/staff")
public class StaffWeb {
	
	@Autowired
	private StaffSv staffSv ;
	
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("mainPage", "staff/save.jsp");
		mav.addObject("modeName", "设备管理");
		mav.setViewName("main");
		
		if(StringUtil.isNotEmpty(id)){
			mav.addObject("actionName", "设备修改");
			Staff staff=staffSv.loadById(Integer.parseInt(id));
			mav.addObject("staff", staff);
		}else{
			mav.addObject("actionName", "设备添加");			
		}
		return mav;
	}

}
