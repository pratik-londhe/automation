package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.HomeHeader;
import com.brandlive.qa.automation.greenroom.pages.HomeLeftNav;
import com.brandlive.qa.automation.utils.Doer;

public class HomeHeaderAndLeftNavAdapter extends Doer {
	
	HomeLeftNav homeLeftNav = new HomeLeftNav();
	HomeHeader homeHeader =  new HomeHeader();
	
	public void selectChannel() {
		if(!homeLeftNav.checkChannelSelected()) {
			homeLeftNav.selectChannel();
		}
	}

	public void createSGREvent(){
		homeHeader.createSGREvent();
	}
}
