package domain;

public class PageMaker {
	private int start;
	private int end;
	private boolean prev;
	private boolean next;
	private int totalCount;
	private int navNum=10;
	private PageCriteria pc;
	private void calculate() {
		end=(int)(Math.ceil(pc.getPageNum()/(double)navNum)*navNum);
		start=(end-navNum)+1;
		int tmpEnd=(int)(Math.ceil(totalCount/(double)pc.getArticleNum()));
		if(end>tmpEnd) {
			end=tmpEnd;
		}
		prev=start==1?false:true;
		next=end*pc.getArticleNum()>=totalCount?false:true;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calculate();
	}
	public int getNavNum() {
		return navNum;
	}
	public void setNavNum(int navNum) {
		this.navNum = navNum;
	}
	public PageCriteria getPc() {
		return pc;
	}
	public void setPc(PageCriteria pc) {
		this.pc = pc;
	}
	@Override
	public String toString() {
		return "pagemaker .....\ntotalcount : "+totalCount+"\nnavnum : "+navNum+
				"\nstart : "+start+"\nend : "+end+"\nprev : "+prev+"\nnext : "+next;
	}
}
