package domain;

public class PageCriteria {
	private int pageNum;
	private int articleNum;
	public PageCriteria() {
		this.pageNum=1;
		this.articleNum=5;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if(pageNum<=0) {
			this.pageNum=1;
		}else {
			this.pageNum = pageNum;
		}
	}
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		if(articleNum<=0||articleNum>30) {
			this.articleNum=10;
		}else {
			this.articleNum = articleNum;
		}
	}
	public int getStart() {
		return (this.pageNum-1)*articleNum+1;
	}
	public int getEnd() {
		return this.pageNum*articleNum;
	}
	@Override
	public String toString() {
		return "pagecriteria .....\npagenum : "+pageNum+"\narticlenum : "+articleNum+
				"\nstart : "+getStart()+"\nend : "+getEnd();
	}
}
