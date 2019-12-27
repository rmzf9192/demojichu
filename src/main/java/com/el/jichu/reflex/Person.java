package com.el.jichu.reflex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/4 15:11
 * @Version:V1.0
 * @Description:Person
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;

    public Person() {
        System.out.println("hello");
    }
}
