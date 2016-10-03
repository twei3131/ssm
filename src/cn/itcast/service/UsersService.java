package cn.itcast.service;

import cn.itcast.ssm.po.UserVo;

public interface UsersService {
	
	public UserVo findUserById(String id);
}
