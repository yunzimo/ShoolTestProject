package com.offcn.Utils;

public class LimitTool {
    private int totalCount; //总记录数
    private int pageSize;   //一个页面有多少记录
    private int currentPage; //当前页数
    private int totalPages; //一共有多少页
    private int startIndex; //每一个页面开始的索引
    private int prePage;   //上一页
    private int nextPage;  //下一页

    public LimitTool(int totalCount, int pageSize, String currentPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        InitCurrentPage(currentPage);
        InitTotalPages();
        InitStartIndex();
        InitPrePage();
        InitNextPage();
    }

    public void InitCurrentPage(String currentPage){
        if(currentPage==null){
            this.currentPage=1;
        }else{
            this.currentPage= Integer.parseInt(currentPage);
        }
    }


    public void InitTotalPages(){
        this.totalPages=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
    }
    public void InitStartIndex(){
        this.startIndex=(this.currentPage-1)*this.pageSize;
    }
    public void InitPrePage(){
        if(this.currentPage==1){
            this.prePage=this.totalPages;
        }else{
            this.prePage=this.currentPage-1;
        }
    }
    public void InitNextPage(){
        if(this.currentPage==this.totalPages){
            this.nextPage=1;
        }else{
            this.nextPage=this.currentPage+1;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
