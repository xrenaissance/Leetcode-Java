package com.inuker.solution;

/**
 * Created by liwentian on 2017/10/16.
 */

public class DesignTinyURL {

    /**
     * 这题和#535. Encode and Decode TinyURL类似，不过这题更偏向于系统设计
     *
     * 1. How many unique identifiers possible? Will you run out of unique URLs?
     * 如果按6个字符计算，一共有62**6种可能，大概三百多亿，越到后面碰撞越来越多，可以通过增加字符数来解决
     *
     * 2. Should the identifier be increment or not? Which is easier to design? Pros and cons?
     * 不能，那样容易被破解
     */


    /**
     * 可参考https://segmentfault.com/a/1190000006140476
     */

}
