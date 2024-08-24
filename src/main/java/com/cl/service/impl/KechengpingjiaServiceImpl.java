package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.KechengpingjiaDao;
import com.cl.entity.KechengpingjiaEntity;
import com.cl.service.KechengpingjiaService;
import com.cl.entity.view.KechengpingjiaView;

@Service("kechengpingjiaService")
public class KechengpingjiaServiceImpl extends ServiceImpl<KechengpingjiaDao, KechengpingjiaEntity> implements KechengpingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengpingjiaEntity> page = this.selectPage(
                new Query<KechengpingjiaEntity>(params).getPage(),
                new EntityWrapper<KechengpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengpingjiaEntity> wrapper) {
		  Page<KechengpingjiaView> page =new Query<KechengpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengpingjiaView> selectListView(Wrapper<KechengpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengpingjiaView selectView(Wrapper<KechengpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
