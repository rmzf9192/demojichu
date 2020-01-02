package com.el.jichu.designpattern.visitor.test;

public class Man extends Person {

	@Override
	public void accept(Action action) {
		action.getManResult(this);
	}

}
