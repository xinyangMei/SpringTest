package com.mxy.example.listerer;

import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/25
 * @description
 */
@Component
public class UserPojo {

    private String name;

    public UserPojo() {
        name = "mxy";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName------------->" + name);
        this.name = name;
    }

//    @Override
    public void afterPropertiesSet() throws Exception {
        name = "zy";
        System.out.println("------->afterPropertiesSet----------->name:"+name);
    }

    @Override
    public String toString() {
        return "{\"UserPojo\":{"
                + "                        \"name\":\"" + name + "\""
                + "}}";
    }
}
