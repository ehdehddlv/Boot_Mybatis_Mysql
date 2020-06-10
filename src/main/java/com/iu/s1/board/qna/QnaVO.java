package com.iu.s1.board.qna;

import com.iu.s1.board.BoardVO;

public class QnaVO extends BoardVO{

	private int ref;
	private int step;
	private int depth;
	
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	
}
