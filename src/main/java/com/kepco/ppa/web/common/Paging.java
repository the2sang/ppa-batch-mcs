package com.kepco.ppa.web.common;

public class Paging {

    private int TotalCnt;
    private int CurPage;
    private int StartPageNo = 0;
    private int EndPageNo = 0;
    private int PrePageNo = 0;
    private int NextPageNo = 0;
    private int StartRow = 0;
    private int EndRow = 0;
    private int TotalPage = 0;

    public void setTotalCnt(int TotalCnt) {
        this.TotalCnt = TotalCnt;
    }

    public int getTotalCnt() {
        return this.TotalCnt;
    }

    public void setCurPage(int CurPage) {
        this.CurPage = CurPage;
    }

    public int getCurPage() {
        return this.CurPage;
    }

    public void setStartPageNo(int StartPageNo) {
        this.StartPageNo = StartPageNo;
    }

    public int getStartPageNo() {
        return this.StartPageNo;
    }

    public void setEndPageNo(int EndPageNo) {
        this.EndPageNo = EndPageNo;
    }

    public int getEndPageNo() {
        return this.EndPageNo;
    }

    public void setPrePageNo(int PrePageNo) {
        this.PrePageNo = PrePageNo;
    }

    public int getPrePageNo() {
        return this.PrePageNo;
    }

    public void setNextPageNo(int NextPageNo) {
        this.NextPageNo = NextPageNo;
    }

    public int getNextPageNo() {
        return this.NextPageNo;
    }

    public void setStartRow(int StartRow) {
        this.StartRow = StartRow;
    }

    public int getStartRow() {
        return this.StartRow;
    }

    public void setEndRow(int EndRow) {
        this.EndRow = EndRow;
    }

    public int getEndRow() {
        return this.EndRow;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public int getTotalPage() {
        return this.TotalPage;
    }

    public void PageCalc(int curPage, int totalPage, int ListSize) {
        if (curPage == 0) curPage = 1;

        this.CurPage = curPage;
        this.TotalPage = totalPage;

        if ((curPage / 10) < 1) {
            StartPageNo = 1;
        } else {
            if ((curPage % 10) == 0) {
                StartPageNo = (curPage / 10) * 10 - 9;
            } else {
                StartPageNo = (curPage / 10) * 10 + 1;
            }
        }
        if (this.TotalPage < (StartPageNo + 9)) {
            EndPageNo = this.TotalPage;
        } else {
            EndPageNo = StartPageNo + 9;
        }

        if ((StartPageNo - 10) < 0) {
            PrePageNo = 1;
        } else {
            PrePageNo = StartPageNo - 1;
        }
        if ((EndPageNo + 1) > this.TotalPage) {
            NextPageNo = this.TotalPage;
        } else {
            NextPageNo = EndPageNo + 1;
        }
    }
}
