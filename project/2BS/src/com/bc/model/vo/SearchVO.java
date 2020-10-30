package com.bc.model.vo;

//게시판의 페이징 처리를 위한 값을 저장 관리
public class SearchVO {
	private int begin;
	private int end;
	private String keyword;
	private int idx;
	private int t_code;
	private int su_num;

	
	public int getSu_num() {
		return su_num;
	}
	public void setSu_num(int su_num) {
		this.su_num = su_num;
	}
	public int getT_code() {
		return t_code;
	}
	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	@Override
	public String toString() {
		return "SearchVO [begin=" + begin + ", end=" + end + ", keyword=" + keyword + ", idx=" + idx + ", t_code="
				+ t_code + "]";
	}

	
	
	
}
















