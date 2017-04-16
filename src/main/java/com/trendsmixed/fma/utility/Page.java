package com.trendsmixed.fma.utility;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonView;

public class Page<T>{

	@JsonView(PageView.Content.class)	
	List<T> content;
	@JsonView(PageView.Number.class)	
	private int number;
	@JsonView(PageView.NumberOfElements.class)	
	private int numberOfElements;
	@JsonView(PageView.Size.class)	
	private int size;
	@JsonView(PageView.Sort.class)	
	private Sort sort;
	@JsonView(PageView.TotalElements.class)	
	private long totalElements;
	@JsonView(PageView.TotalPages.class)	
	private int totalPages;

	public Page(org.springframework.data.domain.Page<T> aPage) {
		this.content = aPage.getContent();
		this.number = aPage.getNumber();
		this.numberOfElements = aPage.getNumberOfElements();
		this.size = aPage.getSize();
		this.sort = aPage.getSort();
		this.totalElements = aPage.getTotalElements();
		this.totalPages = aPage.getTotalPages();
	}

}
