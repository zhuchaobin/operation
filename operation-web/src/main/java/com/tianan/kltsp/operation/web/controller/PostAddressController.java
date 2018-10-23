package com.tianan.kltsp.operation.web.controller;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.minlog.Log;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.common.api.support.SecurityContext;

import com.tianan.common.mvc.controller.BaseController;

import com.tianan.kltsp.dc.client.inter.PostAddressDcService;
import com.tianan.kltsp.dc.client.inter.T1ARInfDcService;
import com.tianan.kltsp.dc.client.request.PostAddressDcReq;
import com.tianan.kltsp.dc.client.vo.PostAddressVo;
import com.tianan.kltsp.dc.client.vo.T1ARInfVo;
import com.tianan.kltsp.operation.client.vo.LoginUser;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/*
 * 
 * @ClassName:  postAddressController   
 * @Description:收货地址信息管理
 * @author: zhuchaobin
 * @date:   2018年7月10日 下午7:00:23  
 *
 */
@Controller
@RequestMapping("postAddress")
public class PostAddressController extends BaseController {
	
	@Autowired
	private PostAddressDcService postAddressDcService;
	@Autowired
	private T1ARInfDcService t1ARInfDcService2;
	
/*    @RequestMapping(value = { "list" })
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("postAddress/list");

        CarModelQuery query = new CarModelQuery();
        query.setStatus(true);
        query.setPageNo(1);
        query.setPageSize(Integer.MAX_VALUE);
        Result<PageInfo<CarModelBaseVo>> carModelResult = carModelService.queryPage(query);
        if (carModelResult == null || carModelResult.getCode() != 0) {
            throw new RuntimeException("查询车型异常");
        }
        mv.addObject("carModels", carModelResult.getData().getList());

        LoginUser user = (LoginUser) SecurityContext.getAuthUser();
        mv.addObject("usertype", user.getUserType().name());
        return mv;
    	
    	ModelAndView mv = new ModelAndView("postAddress/list");

		T1ARInfVo query = new T1ARInfVo();

		Result<PageData<T1ARInfVo>> rlt = t1ARInfDcService2.queryPage(query, null);
		
        CarModelQuery query = new CarModelQuery();
        query.setStatus(true);
        query.setPageNo(1);
        query.setPageSize(Integer.MAX_VALUE);
        Result<PageInfo<CarModelBaseVo>> carModelResult = carModelService.queryPage(query);
        if (carModelResult == null || carModelResult.getCode() != 0) {
            throw new RuntimeException("查询车型异常");
        }
        mv.addObject("carModels", carModelResult.getData().getList());

        LoginUser user = (LoginUser) SecurityContext.getAuthUser();
        mv.addObject("usertype", user.getUserType().name());
        return mv;
    	return null;
    }
*/
	
    @RequestMapping(value = { "add" })
    @ResponseBody
    public ModelAndView add(T1ARInfVo postAddressDcQuery, PageParam pageParam) {
        ModelAndView mav = new ModelAndView("postAddress/add");
        return mav;
    }
    
    @RequestMapping(value = { "list" })
    @ResponseBody
    public Result<?> queryPage(T1ARInfVo postAddressDcQuery, PageParam pageParam) {
    	logger.info("收货地址查询请求参数:{}，分页参数：{}", JSON.toJSONString(postAddressDcQuery),JSON.toJSONString(pageParam));
        Result<PageData<T1ARInfVo>> result = t1ARInfDcService2.queryPage(postAddressDcQuery, pageParam);

        return Result.createSuccessResult(result.getData());
    }
    
 /*   @RequestMapping("/get")
    @ResponseBody
    public Result<?> get(Integer id) {
        logger.info("查询收货地址信息，id={}", id);
        Result<postAddress> result = postAddressDcService.queryrById(id);
        logger.info("查询养参数信息返回结果：{}", JSON.toJSONString(result));
        return result;
    }
    
    @RequestMapping("/save")
    @ResponseBody
    public Result<?> save(postAddress model) {
        logger.info("保存收货地址信息：{}", JSON.toJSONString(model));

        if(StringUtils.isBlank(model.getName())) {
        	Log.error("保存或新增收货地址信息, [套餐名称]不能为空！");
        	return Result.createFailResult("保存或新增收货地址信息, [套餐名称]不能为空！");
        }
        if(null == model.getFlowQuantity()) {
        	Log.error("保存或新增收货地址信息, [流量]不能为空！");
        	return Result.createFailResult("保存或新增收货地址信息, [流量]不能为空！");
        }
        if(null == model.getEffMonth()) {
        	Log.error("保存或新增收货地址信息, [有效期]不能为空！");
        	return Result.createFailResult("保存或新增收货地址信息, [有效期]不能为空！");
        }
        if(StringUtils.isBlank(model.getOperatorFlag())) {
        	Log.error("保存或新增收货地址信息, [运营商标志]不能为空！");
        	return Result.createFailResult("保存或新增收货地址信息, [运营商标志]不能为空！");
        }
        if(StringUtils.isBlank(model.getWhiteList())) {
        	Log.error("保存或新增收货地址信息, [白名单]不能为空！");
        	return Result.createFailResult("保存或新增收货地址信息, [白名单]不能为空！");
        }
        Result<?> result = postAddressDcService.updateOrInsert(model);
        logger.info("保存收货地址信息返回结果：{}", JSON.toJSONString(result));

        return result;
    }
    
    @RequestMapping("/del")
    @ResponseBody
    public Result<?> del(Integer id) {
        logger.info("删除收货地址信息，id={}", id);
        if(null == id) {
        	Log.error("删除收货地址信息, [收货地址ID]不能为空！");
        	return Result.createFailResult("删除收货地址信息, [收货地址ID]不能为空！");
        }
        Result<?> result = postAddressDcService.deleteById(id);
        logger.info("删除养参数信息返回结果：{}", JSON.toJSONString(result));
        return result;
    }*/
   
}
