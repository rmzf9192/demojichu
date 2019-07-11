package com.el.jichu.designpattern.iterator.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:51
 * @Version:V1.0
 * @Description:Client
 */
public class Client {
    public static void main(String[] args) {
        //创建学院
        List<College> collegeList = new ArrayList<College>();

        ComputerColleage computerCollege = new ComputerColleage();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        //collegeList.add(infoCollege);

        OutPutImpl outPutImpl = new OutPutImpl(collegeList);
        outPutImpl.printCollege();
    }
}
