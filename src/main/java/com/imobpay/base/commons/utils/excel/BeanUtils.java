package com.imobpay.base.commons.utils.excel;

import java.beans.PropertyDescriptor;

import java.lang.reflect.Method;

import java.util.Map;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

/**
 *
 * <pre>
 * 【类型】: BeanUtils <br/>
 * 【作用】: 基于CGlib 实体工具类，目前copy不支持map、list. <br/>
 * 【时间】：2017年5月23日 上午9:59:20 <br/>
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public final class BeanUtils extends org.springframework.beans.BeanUtils {

    /**  */
    private BeanUtils() {}

    /**
     * copy 对象属性到另一个对象，默认不使用Convert
     *
     * @param src
     * @param clazz
     *            类名
     * @param <T>
     * @return T
     */
    public static <T> T copy(Object src, Class<T> clazz) {
        BeanCopier copier = BeanCopier.create(src.getClass(), clazz, false);
        T          to     = newInstance(clazz);

        copier.copy(src, to, null);

        return to;
    }

    /**
     * 拷贝对象
     *
     * @param src
     *            源对象
     * @param dist
     *            需要赋值的对象
     */
    public static void copy(Object src, Object dist) {
        BeanCopier copier = BeanCopier.create(src.getClass(), dist.getClass(), false);

        copier.copy(src, dist, null);
    }

    /**
     *
     * 【方法名】 : 实例化对象. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:28:41 .<br/>
     * 【参数】： .<br/>
     *
     * @param clazz
     *            .<br/>
     * @param <T>
     *            .<br/>
     * @return .<br/>
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<?> clazz) {
        return (T) instantiate(clazz);
    }

    /**
     * 实例化对象
     *
     * @param clazzStr
     *            类名
     * @param <T>
     *            .<br/>
     * @return 对象
     */
    public static <T> T newInstance(String clazzStr) {
        try {
            Class<?> clazz = Class.forName(clazzStr);

            return newInstance(clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * 【方法名】 : 将map 转为 bean. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:31:49 .<br/>
     * 【参数】： .<br/>
     *
     * @param beanMap
     * @param valueType
     * @param <T>
     * @return .<br/>
     */
    public static <T> T toBean(Map<String, Object> beanMap, Class<T> valueType) {
        T                    bean    = BeanUtils.newInstance(valueType);
        PropertyDescriptor[] beanPds = getPropertyDescriptors(valueType);

        for (PropertyDescriptor propDescriptor : beanPds) {
            String propName = propDescriptor.getName();

            // 过滤class属性
            if ("class".equals(propName)) {
                continue;
            }

            if (beanMap.containsKey(propName)) {
                Method writeMethod = propDescriptor.getWriteMethod();

                if (null == writeMethod) {
                    continue;
                }

                Object value = beanMap.get(propName);

                if (!writeMethod.isAccessible()) {
                    writeMethod.setAccessible(true);
                }

                try {
                    writeMethod.invoke(bean, value);
                } catch (Throwable e) {
                    throw new RuntimeException("Could not set property '" + propName + "' to bean", e);
                }
            }
        }

        return bean;
    }

    /**
     *
     * 【方法名】 : 将对象装成map形式. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:33:05 .<br/>
     * 【参数】： .<br/>
     *
     * @param src
     * @return .<br/>
     */
    @SuppressWarnings("rawtypes")
    public static Map toMap(Object src) {
        return BeanMap.create(src);
    }

    /**
     * 获取Bean的属性
     *
     * @param bean
     *            bean
     * @param propertyName
     *            属性名
     * @return 属性值
     */
    public static Object getProperty(Object bean, String propertyName) {
        PropertyDescriptor pd = getPropertyDescriptor(bean.getClass(), propertyName);

        if (pd == null) {
            throw new RuntimeException("Could not read property '" + propertyName
                                       + "' from bean PropertyDescriptor is null");
        }

        Method readMethod = pd.getReadMethod();

        if (readMethod == null) {
            throw new RuntimeException("Could not read property '" + propertyName + "' from bean readMethod is null");
        }

        if (!readMethod.isAccessible()) {
            readMethod.setAccessible(true);
        }

        try {
            return readMethod.invoke(bean);
        } catch (Throwable ex) {
            throw new RuntimeException("Could not read property '" + propertyName + "' from bean", ex);
        }
    }

    /**
     * 设置Bean属性
     *
     * @param bean
     *            bean
     * @param propertyName
     *            属性名
     * @param value
     *            属性值
     */
    public static void setProperty(Object bean, String propertyName, Object value) {
        PropertyDescriptor pd = getPropertyDescriptor(bean.getClass(), propertyName);

        if (pd == null) {
            throw new RuntimeException("Could not set property '" + propertyName
                                       + "' to bean PropertyDescriptor is null");
        }

        Method writeMethod = pd.getWriteMethod();

        if (writeMethod == null) {
            throw new RuntimeException("Could not set property '" + propertyName + "' to bean writeMethod is null");
        }

        if (!writeMethod.isAccessible()) {
            writeMethod.setAccessible(true);
        }

        try {
            writeMethod.invoke(bean, value);
        } catch (Throwable ex) {
            throw new RuntimeException("Could not set property '" + propertyName + "' to bean", ex);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
