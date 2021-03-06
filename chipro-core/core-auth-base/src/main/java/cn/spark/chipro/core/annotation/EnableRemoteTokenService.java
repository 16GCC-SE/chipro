package cn.spark.chipro.core.annotation;


import cn.spark.chipro.core.service.CustomRemoteTokenService;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: liliguang
 * @date: 2019-11-10 09:45
 * @description: 在启动类上添加该注解来----开启远程token服务
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomRemoteTokenService.class)
public @interface EnableRemoteTokenService {
}
