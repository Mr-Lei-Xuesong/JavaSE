package com.test;

import com.sun.deploy.util.StringUtils;

import javax.lang.model.element.VariableElement;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:   xuesong.lei
 * Date:     2022/12/19 20:51
 * Description:
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "《测试标题》请求处理审批##北京移动系统集成有限公司-合作拓展室##刘喜伟";
        String[] split = str.split("##");
        if (split.length>2){
            System.out.println("Hello World!");
            System.out.println(split[1]);
            System.out.println(split[2]);
        }
        System.out.println(split.length);
    }
}
