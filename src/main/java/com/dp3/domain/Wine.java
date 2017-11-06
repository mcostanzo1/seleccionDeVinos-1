package com.dp3.domain;

public class Wine extends Product {
	
	private Cellar cellar;
	
	public Wine(Cellar cellar, String name, int quantityOnBox, String clasify) {
//		super.productCode = getNextSequenceId();
		this.cellar = cellar;
		super.name = name;
		super.quantityOnBox = quantityOnBox;
		super.clasify = clasify;
	}
	
	public Cellar getCellar() {
		return cellar;
	}
}
