package org.lc.springboot.aspect;

import org.lc.springboot.common.SpringBootBaseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面配置
 * @author lc
 * @version 1.0.0
 * @date 2018-12-14 14:04:43
 * @since 1.0.0
 */
@Aspect
@Component
@Slf4j
public class MyAspect {

    private final String POINT_CUT = "execution(public * StudentController.*(..))";

    private ThreadLocal<Long> startTimestamp = new ThreadLocal<>();

    private int times = 0;

    /**
     * 配置切点
     */
    @Pointcut(POINT_CUT)
    public void pointCut() {
        // 该方法里面的代码不被执行
    }

    /**
     * 环绕通知
     * 如果没有pjp.proceed()，待环绕通知执行完后就执行前置通知
     * 如果有，就会执行前置通知
     * 环绕通知方法体执行完后执行前置通知
     * @param pjp 继续执行切入点对象
     * @return controller的返回结果
     * @throws Throwable 异常或者系统错误
     */
    @Around(value = "pointCut()")
    public SpringBootBaseResult around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("环绕通知");
        log.info("目标方法名：{}", pjp.getSignature().getName());
        return (SpringBootBaseResult) pjp.proceed();
    }


    /**
     * 前置通知
     * @param joinPoint 连接点
     */
    @Before(value = "pointCut()", argNames = "joinPoint")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request;
        if (attributes != null) {
            request = attributes.getRequest();
            log.info("本次请求方IP：" + request.getRemoteHost() + " 请求路径：" + request.getRequestURI());
            log.info("本次请求参数是：{}", Arrays.toString(joinPoint.getArgs()));
        }

        Signature signature = joinPoint.getSignature();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long remainMemory = Runtime.getRuntime().freeMemory();
        log.info("切点是: {}", signature.getDeclaringTypeName());
        log.info("切点方法是: {}", signature.getName());

        log.info("JVM总内存：{}MB", totalMemory / 1024 / 1024);
        log.info("JVM剩余内存：{}MB", remainMemory / 1024 / 1024);
        startTimestamp.set(System.currentTimeMillis());

    }


    /**
     * 后置通知
     */
    @After("pointCut()")
    public void after() {
        long cost = System.currentTimeMillis() - startTimestamp.get();
        times += 1;
        log.info("本次请求耗时：{}ms", cost);
        log.info("系统总计被调用：{}次", times);
        startTimestamp.remove();
    }


    /**
     * 后置返回通知
     *
     * @param keys 返回值
     */
    @AfterReturning(value = "pointCut()", returning = "keys", argNames = "keys")
    public void afterReturning(String keys) {
        log.info("请求返回结果：{}", keys);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        log.info("发生异常时执行");
    }


}
