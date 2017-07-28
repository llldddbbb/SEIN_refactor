package com.sein.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisplayConfigTest {
    @Test
    public void testReflect(){
        Class c = null;
        try {
            c = Class.forName("com.sein.pojo.po.DisplayConfig");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fs = c.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        for(Field field:fs){
            sb.append("\t");//空格
            sb.append(field.getName()+";\n");//属性的名字+回车
        }
        sb.append("}");
        System.out.println(sb);
    }
}
