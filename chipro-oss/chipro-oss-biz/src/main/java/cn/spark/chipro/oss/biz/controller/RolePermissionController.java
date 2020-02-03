package cn.spark.chipro.oss.biz.controller;

import cn.spark.chipro.oss.biz.entity.RolePermission;
import cn.spark.chipro.oss.biz.model.params.RolePermissionParam;
import cn.spark.chipro.oss.biz.model.result.RolePermissionResult;
import cn.spark.chipro.oss.biz.service.RolePermissionService;
import cn.spark.chipro.core.page.PageInfo;
import cn.spark.chipro.core.result.Result;
import cn.spark.chipro.core.controller.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 角色权限关系表控制器
 *
 * @author 李利光
 * @Date 2020-01-31 13:26:51
 */
@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController extends BaseController {

    private String PREFIX = "/rolePermission";

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 新增接口
     *
     * @author 李利光
     * @Date 2020-01-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public Result addItem(RolePermissionParam rolePermissionParam) {
        this.rolePermissionService.add(rolePermissionParam);
        return Result.success();
    }

    /**
     * 编辑接口
     *
     * @author 李利光
     * @Date 2020-01-31
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public Result editItem(RolePermissionParam rolePermissionParam) {
        this.rolePermissionService.update(rolePermissionParam);
        return Result.success();
    }

    /**
     * 删除接口
     *
     * @author 李利光
     * @Date 2020-01-31
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(RolePermissionParam rolePermissionParam) {
        this.rolePermissionService.delete(rolePermissionParam);
        return Result.success();
    }

    /**
     * 查看详情接口
     *
     * @author 李利光
     * @Date 2020-01-31
     */
    @RequestMapping("/detail")
    @ResponseBody
    public Result detail(RolePermissionParam rolePermissionParam) {
        RolePermission detail = this.rolePermissionService.getById(rolePermissionParam.getRoleAndPermissionId());
        return Result.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 李利光
     * @Date 2020-01-31
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageInfo list(RolePermissionParam rolePermissionParam) {
        return this.rolePermissionService.findPageBySpec(rolePermissionParam);
    }

}


