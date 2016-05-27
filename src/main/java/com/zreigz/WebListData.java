package com.zreigz;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebListData {

	private String text;
	
	public WebListData(){
		
	}
	
	public WebListData(String text) {

        this.text = text;
    }


    @JsonProperty
    public String getText() {
        return text;
    }
}
