package com.imobpay.base.commons.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.imobpay.base.constant.GlobalConstant;

/**
 *
 * <pre>
 * 【类型】: DigestUtils <br/>
 * 【作用】: 加密相关工具类直接使用Spring util封装，减少jar依赖. <br/>
 * 【时间】：2017年5月22日 下午2:18:33 <br/>
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class DigestUtils extends org.springframework.util.DigestUtils {

    /**
     * 使用shiro的hash方式
     *
     * @param algorithmName
     *            算法
     * @param source
     *            源对象
     * @param salt
     *            加密盐
     * @param hashIterations
     *            hash次数
     * @return 加密后的字符
     */
    public static String hashByShiro(String algorithmName, Object source, Object salt, int hashIterations) {
        return new SimpleHash(algorithmName, source, salt, hashIterations).toHex();
    }

    /**
     * Return a hexadecimal string representation of the MD5 digest of the given
     * bytes.
     *
     * @param bytes
     *            the bytes to calculate the digest over
     * @return a hexadecimal digest string
     */
    public static String md5Hex(final byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex string.
     *
     * @param data
     *            Data to digest
     * @return MD5 digest as a hex string
     */
    public static String md5Hex(final String data) {
        return DigestUtils.md5DigestAsHex(data.getBytes(GlobalConstant.UTF_8));
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
