/**
 * The MIT License (MIT)
 * Copyright (c) 2016 Dreamlu (596392912@qq.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */



package com.imobpay.base.commons.shiro.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.apache.shiro.cache.CacheException;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

import com.imobpay.base.commons.log.LogPay;

/**
 *
 * <pre>
 * 【类型】: ShiroSpringCache <br/>
 * 【作用】: 使用spring-cache作为shiro缓存. <br/>
 * 【时间】：2017年5月23日 上午10:24:51 <br/>
 * 【作者】：Ferry Chen <br/>
 * &#64;param <K>
 * &#64;param <V>
 * </pre>
 */
@SuppressWarnings("unchecked")
public class ShiroSpringCache<K, V> implements org.apache.shiro.cache.Cache<K, V> {

    /**  */
    private final org.springframework.cache.Cache cache;

    /**
     *
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:25:10 .<br/>
     * 【参数】： .<br/>
     *
     * @param cache
     *            .<br/>
     */
    public ShiroSpringCache(Cache cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }

        this.cache = cache;
    }

    @Override
    public void clear() throws CacheException {
        LogPay.trace("Clearing all objects from cache [" + this.cache.getName() + "]");
        cache.clear();
    }

    @Override
    public Set<K> keys() {
        return Collections.emptySet();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        LogPay.trace("Putting object in cache [" + this.cache.getName() + "] for key [" + key + "]key type:"
                     + key.getClass());

        V previous = get(key);

        cache.put(key, value);

        return previous;
    }

    @Override
    public V remove(K key) throws CacheException {
        LogPay.trace("Removing object from cache [" + this.cache.getName() + "] for key [" + key + "]key type:"
                     + key.getClass());

        V previous = get(key);

        cache.evict(key);

        return previous;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "ShiroSpringCache [" + this.cache.getName() + "]";
    }

    @Override
    public Collection<V> values() {
        return Collections.emptySet();
    }

    @Override
    public V get(K key) throws CacheException {
        LogPay.trace("Getting object from cache [" + this.cache.getName() + "] for key [" + key + "]key type:"
                     + key.getClass());

        ValueWrapper valueWrapper = cache.get(key);

        if (valueWrapper == null) {
            LogPay.trace("Element for [" + key + "] is null.");

            return null;
        }

        return (V) valueWrapper.get();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
