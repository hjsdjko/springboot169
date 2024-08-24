package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengpingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengpingjiaView;


/**
 * 课程评价
 *
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
public interface KechengpingjiaService extends IService<KechengpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengpingjiaView> selectListView(Wrapper<KechengpingjiaEntity> wrapper);
   	
   	KechengpingjiaView selectView(@Param("ew") Wrapper<KechengpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengpingjiaEntity> wrapper);
   	

}

