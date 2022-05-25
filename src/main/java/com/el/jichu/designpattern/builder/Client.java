package com.el.jichu.designpattern.builder;

public class Client {

	public static void main(String[] args) {
		CommonHouse commonHouse = new CommonHouse();
		final HouseDirector houseDirector = new HouseDirector(commonHouse);
		final House house = houseDirector.createHouse();
		System.out.println(house);
	}

}
