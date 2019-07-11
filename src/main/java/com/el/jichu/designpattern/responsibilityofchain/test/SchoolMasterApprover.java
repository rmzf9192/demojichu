package com.el.jichu.designpattern.responsibilityofchain.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 9:08
 * @Version:V1.0
 * @Description:SchoolMasterApprover
 */
public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {

        if(purchaseRequest.getPrice() > 30000){
            System.out.println("请求编号 id= "+purchaseRequest.getId()+"被"+this.name+"处理了");
        }else{
            approver.processRequest(purchaseRequest);
        }
    }
}
