package com.el.jichu.designpattern.responsibilityofchain.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 9:10
 * @Version:V1.0
 * @Description:Client
 */
public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 6000, 1);

        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校长");

        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("李校长");

        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);


        departmentApprover.processRequest(purchaseRequest);
        //viceSchoolMasterApprover.processRequest(purchaseRequest);
    }
}
