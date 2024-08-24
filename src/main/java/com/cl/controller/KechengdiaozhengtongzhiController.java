package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.KechengdiaozhengtongzhiEntity;
import com.cl.entity.view.KechengdiaozhengtongzhiView;

import com.cl.service.KechengdiaozhengtongzhiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程调整通知
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
@RestController
@RequestMapping("/kechengdiaozhengtongzhi")
public class KechengdiaozhengtongzhiController {
    @Autowired
    private KechengdiaozhengtongzhiService kechengdiaozhengtongzhiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengdiaozhengtongzhi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengdiaozhengtongzhiEntity> ew = new EntityWrapper<KechengdiaozhengtongzhiEntity>();

		PageUtils page = kechengdiaozhengtongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengdiaozhengtongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi, 
		HttpServletRequest request){
        EntityWrapper<KechengdiaozhengtongzhiEntity> ew = new EntityWrapper<KechengdiaozhengtongzhiEntity>();

		PageUtils page = kechengdiaozhengtongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengdiaozhengtongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi){
       	EntityWrapper<KechengdiaozhengtongzhiEntity> ew = new EntityWrapper<KechengdiaozhengtongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengdiaozhengtongzhi, "kechengdiaozhengtongzhi")); 
        return R.ok().put("data", kechengdiaozhengtongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi){
        EntityWrapper< KechengdiaozhengtongzhiEntity> ew = new EntityWrapper< KechengdiaozhengtongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengdiaozhengtongzhi, "kechengdiaozhengtongzhi")); 
		KechengdiaozhengtongzhiView kechengdiaozhengtongzhiView =  kechengdiaozhengtongzhiService.selectView(ew);
		return R.ok("查询课程调整通知成功").put("data", kechengdiaozhengtongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi = kechengdiaozhengtongzhiService.selectById(id);
		kechengdiaozhengtongzhi = kechengdiaozhengtongzhiService.selectView(new EntityWrapper<KechengdiaozhengtongzhiEntity>().eq("id", id));
        return R.ok().put("data", kechengdiaozhengtongzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi = kechengdiaozhengtongzhiService.selectById(id);
		kechengdiaozhengtongzhi = kechengdiaozhengtongzhiService.selectView(new EntityWrapper<KechengdiaozhengtongzhiEntity>().eq("id", id));
        return R.ok().put("data", kechengdiaozhengtongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi, HttpServletRequest request){
    	kechengdiaozhengtongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengdiaozhengtongzhi);
        kechengdiaozhengtongzhiService.insert(kechengdiaozhengtongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi, HttpServletRequest request){
    	kechengdiaozhengtongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengdiaozhengtongzhi);
        kechengdiaozhengtongzhiService.insert(kechengdiaozhengtongzhi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengdiaozhengtongzhiEntity kechengdiaozhengtongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengdiaozhengtongzhi);
        kechengdiaozhengtongzhiService.updateById(kechengdiaozhengtongzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengdiaozhengtongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
