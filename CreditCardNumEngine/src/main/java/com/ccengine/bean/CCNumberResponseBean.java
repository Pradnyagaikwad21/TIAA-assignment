package com.ccengine.bean;

public class CCNumberResponseBean {

	private CCNumberBean[] CreaditCard;

	public CCNumberResponseBean(CCNumberBean[] ccNumberBean) {
		this.CreaditCard=ccNumberBean;
	}

	public CCNumberBean[] getCreaditCard() {
		return CreaditCard;
	}

	public void setCreaditCard(CCNumberBean[] creaditCard) {
		CreaditCard = creaditCard;
	}
	
}
