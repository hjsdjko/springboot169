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

import com.cl.entity.KaoqinxinxiEntity;
import com.cl.entity.view.KaoqinxinxiView;

import com.cl.service.KaoqinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 考勤信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 09:55:08
 */
@RestController
@RequestMapping("/kaoqinxinxi")
public class KaoqinxinxiController {
    @Autowired
    private KaoqinxinxiService kaoqinxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaoqinxinxiEntity kaoqinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kaoqinxinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			kaoqinxinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaoqinxinxiEntity> ew = new EntityWrapper<KaoqinxinxiEntity>();

		PageUtils page = kaoqinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoqinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaoqinxinxiEntity kaoqinxinxi, 
		HttpServletRequest request){
        EntityWrapper<KaoqinxinxiEntity> ew = new EntityWrapper<KaoqinxinxiEntity>();

		PageUtils page = kaoqinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoqinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaoqinxinxiEntity kaoqinxinxi){
       	EntityWrapper<KaoqinxinxiEntity> ew = new EntityWrapper<KaoqinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaoqinxinxi, "kaoqinxinxi")); 
        return R.ok().put("data", kaoqinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaoqinxinxiEntity kaoqinxinxi){
        EntityWrapper< KaoqinxinxiEntity> ew = new EntityWrapper< KaoqinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaoqinxinxi, "kaoqinxinxi")); 
		KaoqinxinxiView kaoqinxinxiView =  kaoqinxinxiService.selectView(ew);
		return R.ok("查询考勤信息成功").put("data", kaoqinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaoqinxinxiEntity kaoqinxinxi = kaoqinxinxiService.selectById(id);
		kaoqinxinxi = kaoqinxinxiService.selectView(new EntityWrapper<KaoqinxinxiEntity>().eq("id", id));
        return R.ok().put("data", kaoqinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaoqinxinxiEntity kaoqinxinxi = kaoqinxinxiService.selectById(id);
		kaoqinxinxi = kaoqinxinxiService.selectView(new EntityWrapper<KaoqinxinxiEntity>().eq("id", id));
        return R.ok().put("data", kaoqinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaoqinxinxiEntity kaoqinxinxi, HttpServletRequest request){
    	kaoqinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoqinxinxi);
        kaoqinxinxiService.insert(kaoqinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaoqinxinxiEntity kaoqinxinxi, HttpServletRequest request){
    	kaoqinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoqinxinxi);
        kaoqinxinxiService.insert(kaoqinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaoqinxinxiEntity kaoqinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaoqinxinxi);
        kaoqinxinxiService.updateById(kaoqinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaoqinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
