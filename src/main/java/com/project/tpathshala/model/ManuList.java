package com.project.tpathshala.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "manu_list")
public class ManuList {

	 	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ManuList getParent() {
		return parent;
	}

	public void setParent(ManuList parent) {
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "manu_list_id")
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "parent_id")
	    private ManuList parent;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "icon")
	    private String icon;

	    @Column(name = "url_key")
	    private String urlKey;

	    @Column(name = "created_by")
	    private Long createdBy;

}
