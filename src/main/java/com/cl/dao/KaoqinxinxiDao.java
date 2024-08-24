package com.cl.dao;

import com.cl.entity.KaoqinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaoqinxinxiView;


/**
 * 考勤信息
 * 
 * @author 
 * @email 
 * @date 2024-03-13 09:55:08
 */
public interface KaoqinxinxiDao extends BaseMapper<KaoqinxinxiEntity> {
	
	List<KaoqinxinxiView> selectListView(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);

	List<KaoqinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);
	
	KaoqinxinxiView selectView(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);
	

}
