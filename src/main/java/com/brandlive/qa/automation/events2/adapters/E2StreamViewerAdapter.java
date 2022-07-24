package com.brandlive.qa.automation.events2.adapters;

import com.brandlive.qa.automation.utils.Base;
import com.brandlive.qa.automation.utils.Doer;

public class E2StreamViewerAdapter extends Doer {
	
	Base base = new Base();

	public void navigateToStreamViewer(String channelCode){
		base.navigateToStreamViewer(channelCode);
	}

}
