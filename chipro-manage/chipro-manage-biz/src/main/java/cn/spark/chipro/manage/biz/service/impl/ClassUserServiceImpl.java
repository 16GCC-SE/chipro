package cn.spark.chipro.manage.biz.service.impl;

import cn.spark.chipro.manage.biz.entity.ClassUser;
import cn.spark.chipro.manage.biz.mapper.ClassUserMapper;
import cn.spark.chipro.manage.api.model.params.ClassUserParam;
import cn.spark.chipro.manage.api.model.result.ClassUserResult;
import  cn.spark.chipro.manage.biz.service.ClassUserService;
import cn.spark.chipro.core.page.PageFactory;
import cn.spark.chipro.core.page.PageInfo;
import cn.spark.chipro.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课室老师 服务实现类
 * </p>
 *
 * @author 李利光
 * @since 2020-02-07
 */
@Service
public class ClassUserServiceImpl extends ServiceImpl<ClassUserMapper, ClassUser> implements ClassUserService {

    @Override
    public void add(ClassUserParam param){
        ClassUser entity = getEntity(param);
        this.save(entity);
    }

    public void batchAdd(List<ClassUserParam> classUserParamList){
        if(classUserParamList!=null){
            List<ClassUser> classUserList = new ArrayList<>();
            classUserParamList.forEach(classUserParam->{
                ClassUser classUser = new ClassUser();
                classUser.setUserId(classUserParam.getUserId());
                classUser.setClassRoomId(classUserParam.getClassRoomId());
                classUserList.add(classUser);
            });
            this.saveBatch(classUserList);
        }

    }

    @Override
    public void delete(ClassUserParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ClassUserParam param){
        ClassUser oldEntity = getOldEntity(param);
        ClassUser newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ClassUserResult findBySpec(ClassUserParam param){
        return null;
    }

    @Override
    public List<ClassUserResult> findListBySpec(ClassUserParam param){
        return null;
    }

    @Override
    public PageInfo findPageBySpec(ClassUserParam param){
        Page pageContext=getPageContext();
        QueryWrapper<ClassUser>objectQueryWrapper=new QueryWrapper<>();
        IPage page=this.page(pageContext,objectQueryWrapper);
        return PageFactory.createPageInfo(page);
    }

    private Serializable getKey(ClassUserParam param){
        return param.getClassUserId();
    }

    private Page getPageContext() {
        return new PageFactory().defaultPage();
    }

    private ClassUser getOldEntity(ClassUserParam param) {
        return this.getById(getKey(param));
    }

    private ClassUser getEntity(ClassUserParam param) {
        ClassUser entity = new ClassUser();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
