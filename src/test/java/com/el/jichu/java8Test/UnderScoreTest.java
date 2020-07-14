package com.el.jichu.java8Test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by songhongkang on 2017/12/29 0029.
 */
@Slf4j
public class UnderScoreTest {

    //关于下划线的使用
    @Test
    public void testUnderScore() {
        String str = null;
        Optional<Object> o = Optional.ofNullable(str);
        log.info(o.toString());
        log.info(o.get().toString());
        String str1 = new String();
        log.info(str1.toString());

    }
}
