package com.el.jichu.designpattern.responsibilityofchain.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 9:04
 * @Version:V1.0
 * @Description:DepartmentApprover
 */
public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {

        if(purchaseRequest.getPrice() <= 5000){
            System.out.println("请求编号 id= "+purchaseRequest.getId()+"被"+this.name+"处理了");
        }else{
            approver.processRequest(purchaseRequest);
        }
    }
}
