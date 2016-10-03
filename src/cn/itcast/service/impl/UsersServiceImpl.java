package cn.itcast.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.service.UsersService;
import cn.itcast.ssm.mapper.UsersMapper;
import cn.itcast.ssm.po.UserVo;

public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public UserVo findUserById(String id) {
		UserVo userVo = usersMapper.findUserById(id);
		return userVo;
	}

}
