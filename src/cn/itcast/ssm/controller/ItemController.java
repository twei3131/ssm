package cn.itcast.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.itcast.service.ItemsService;
import cn.itcast.service.UsersService;
import cn.itcast.ssm.mapper.UsersMapper;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.UserVo;


@Controller
@RequestMapping(value="/items")
public class ItemController {
	private static Logger logger = Logger.getLogger(ItemController.class); 
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired 
	private UsersMapper usersMapper;
	
	@RequestMapping(value="/queryItems.action")
	public ModelAndView queryItems()throws Exception{
		
		//����service���� ���ݿ⣬��ѯ��Ʒ�б�����ʹ�þ�̬����ģ��
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		//����ModelAndView
		ModelAndView modelAndView =  new ModelAndView();
		//�൱ ��request��setAttribut����jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);
		
		//ָ����ͼ
		//�±ߵ�·�����������ͼ������������jsp·����ǰ׺��jsp·���ĺ�׺���޸�Ϊ
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		//�ϱߵ�·�����ÿ��Բ��ڳ�����ָ��jsp·����ǰ׺��jsp·���ĺ�׺
		modelAndView.setViewName("items/itemsList");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="editItems.action")
	public ModelAndView editItems(@RequestParam(value="id") Integer id)throws Exception{
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}
	
	@RequestMapping(value="editItemsSubmit.action",method={RequestMethod.POST})
	public ModelAndView editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom)throws Exception{
		logger.debug("�ɹ���");
		itemsService.updateItems(id, itemsCustom);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping(value="findUser.action")
	public ModelAndView findUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.debug("�ɹ���");
		String id = "1";
		UserVo userVo = usersService.findUserById(id);
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(userVo);
		System.out.println("==============="+list.get(0).getSex()+"===============");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userVo", list);
		modelAndView.setViewName("items/user");
		return modelAndView;
	}
	
	@RequestMapping(value="findUsers.action")
	public ModelAndView findUser() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		UserVo userVo = usersMapper.findUserById("1");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(userVo);
		modelAndView.addObject("userVo", list);
		modelAndView.setViewName("items/user");
		return modelAndView;
	}
	
	@RequestMapping(value="getUsers.action")
	public void getUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<UserVo> users = usersMapper.findUsers();
		String json = JSON.toJSONString(users);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		response.getWriter().flush();
	}
}
