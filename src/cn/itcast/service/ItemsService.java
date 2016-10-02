package cn.itcast.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsService {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	public ItemsCustom findItemsById(int id) throws Exception;
	
	public void updateItems(int id,ItemsCustom itemsCustom) throws  Exception;
}
