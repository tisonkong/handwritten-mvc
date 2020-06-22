package com.tison.framework.helper;

import com.tison.framework.util.ReflectionUtil;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tison
 * IoC容器的核心类
 */
public final class BeanContainer {

    /**
     * BEAN_MAP相当于一个bean容器, 拥有项目所有bean的实例
     * map的key为class类，value为类的bean实例
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new ConcurrentHashMap<>();

    static {
        //获取所有bean
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        //将bean实例化, 并放入bean容器中
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取容器实例
     * @return
     */
    public static BeanContainer getInstance(){
        return BeanContainerHolder.HOLDER.instance;
    }

    /**
     * 枚举方式实现单例模式，防序列化攻击
     */
    private enum BeanContainerHolder {
        //IoC容器持有者
        HOLDER;
        private BeanContainer instance;
        BeanContainerHolder(){
            instance = new BeanContainer();
        }
    }

   /**
     * 获取 Bean 容器
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取 Bean 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class: " + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> cls, Object obj) {
        BEAN_MAP.put(cls, obj);
    }
}
