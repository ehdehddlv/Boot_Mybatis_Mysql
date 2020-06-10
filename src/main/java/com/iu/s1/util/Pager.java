package com.iu.s1.util;

public class Pager {

	private Long curPage;		//현재 페이지
	private Integer perPage;	//한번에 보이는 페이지
	
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	
	private long totalBlock;
	private long curBlock;
	
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	//한눈에 보이는 페이지 설정
	public void makeRow() {
		//다음 행으로 넘어갈때 처음으로 보이는 페이지 수  
		this.startRow = (this.getCurPage()-1)*this.getPerPage();
		//다음 행으로 넘어갈때 마지막으로 보이는 페이지 수
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	
	public void makePage(long totalCount) {
		//totalCount = 전체 글의 개수
		this.totalPage = totalCount/this.getPerPage();
		
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		long perBlock = 5L;
		this.totalBlock = totalPage/perBlock;
		
		if(totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		this.curBlock = this.curPage/perBlock;
		
		if(this.curPage % perBlock != 0) {
			this.curBlock++;
		}
		
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(this.curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
		
		
	}
	
	
	public Long getCurPage() {
		if(this.curPage==null || this.curPage==0) {
			this.curPage = 1L;
		}
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage = 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(long totalBlock) {
		this.totalBlock = totalBlock;
	}
	public long getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(long curBlock) {
		this.curBlock = curBlock;
	}
	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
