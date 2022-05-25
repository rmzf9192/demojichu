package com.el.jichu.designpattern.responsibilityofchain.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 8:53
 * @Version:V1.0
 * @Description:Approver
 */
public abstract class Approver {

     Approver approver;

     String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver){
        this.approver = approver;
    }

   public abstract void processRequest(PurchaseRequest purchaseRequest);
}
