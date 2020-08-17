package com.hkk.boottest.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author kang
 * @since 2020/7/13
 */
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {

    /**
     * 如果存在循环依赖的bean在自定义的BeanPostProcessor中返回的实例则会报错
     * 在AbstractAutowireCapableBeanFactory中getEarlyBeanReference和initializeBean只有一个能够修改最终返回的代理bean
     * 如果存在循环依赖，则在getEarlyBeanReference会返回被代理的bean，但是getEarlyBeanReference只会对spring相关的aop起作用，
     * 不会应用所有的BeanPostProcessor，所以如果存在一个bean存在循环依赖，并且有其他的BeanPostProcessor修改了最终的返回代理bean，
     * 那么会走到AbstractAutowireCapableBeanFactory中else if (!this.allowRawInjectionDespiteWrapping && hasDependentBean(beanName))这部分代码
     * 那么最终可能会有问题
     * https://cloud.tencent.com/developer/article/1497692
     * AbstractAutoProxyCreator中的getEarlyBeanReference和BeanPostProcessor中只有一个会执行修改返回实例的方法wrapIfNecessary
     */
    private LogWrapper logWrapper = new LogWrapper();


//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName)
//        throws BeansException {
//        if (bean instanceof LogTest) {
//            logWrapper.setLog((LogTest) bean);
//            return logWrapper;
//        }
//        return bean;
//    }
}
