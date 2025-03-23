package com.dhinesh.loginService.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateModel {

private Date date;
	
	public CustomDateModel(Date date) {
		this.date=date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sdf.format(date);
	}
}
