package com.example.domain;

public class GoodsVO {
    private int goodsid;
    private String goodsname;
    
    public GoodsVO(){}
    public GoodsVO(int goodsid, String goodsname){
        super();

        this.goodsid = goodsid;
        this.goodsname = goodsname;
    }

    public int GetGoodsid(){
        return goodsid;
    }

    public void SetGoodsid(int goodsid){
        this.goodsid = goodsid;
    }

    public String GetGoodsname(){
        return goodsname;
    }

    

}
