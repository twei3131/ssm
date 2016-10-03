package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.UserVo;

public interface UsersMapper {
	public UserVo findUserById(String id);
	
	public List<UserVo> findUsers();
}
