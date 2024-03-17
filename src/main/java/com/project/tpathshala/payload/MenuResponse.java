package com.project.tpathshala.payload;

import java.util.List;

public class MenuResponse {

	private Long id;
	private Long parent;
	private String name;
	private String icon;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParent() {
		return parent;
	}
	public void setParent(Long parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrlKey() {
		return urlKey;
	}
	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}
	public List<MenuResponse> getChildren() {
		return children;
	}
	public void setChildren(List<MenuResponse> children) {
		this.children = children;
	}
	private String urlKey;
	private List<MenuResponse> children;
}
