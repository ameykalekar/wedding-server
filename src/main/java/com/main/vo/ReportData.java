package com.main.vo;

import java.util.List;

public class ReportData{

public ReportData(List data){
this.data=data; 
}

private List data;

public List getData() {
	return data;
}

public void setData(List data) {
	this.data = data;
}

}
