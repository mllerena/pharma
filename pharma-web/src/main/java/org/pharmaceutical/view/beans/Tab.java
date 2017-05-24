package org.pharmaceutical.view.beans;

import java.util.List;
import java.util.Map;

public class Tab { 
 
	private Integer index;
	private String title;
	private String view;
	private String bean;
	private boolean closable;
	
	private Map<String,Object> params;
	
	public Tab(Integer index,String title, String view, String bean, boolean closable,Map<String,Object> params) {
		super();
		this.index = index;
		this.title = title;
		this.view = view;
		this.bean = bean;
		this.closable = closable;
		this.params = params;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean isClosable() {
		return closable;
	}

	public void setClosable(boolean closable) {
		this.closable = closable;
	}
	
	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Tab [index="+ index +", title=" + title + ", view=" + view + ", bean=" + bean
				+ ", closable=" + closable + "]"; 
	}

	

}
