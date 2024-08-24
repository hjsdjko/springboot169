package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KaoqinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaoqinxinxiView;


/**
 * 考勤信息
 *
 * @author 
 * @email 
 * @date 2024-03-13 09:55:08
 */
public interface KaoqinxinxiService extends IService<KaoqinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoqinxinxiView> selectListView(Wrapper<KaoqinxinxiEntity> wrapper);
   	
   	KaoqinxinxiView selectView(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoqinxinxiEntity> wrapper);
   	

}

