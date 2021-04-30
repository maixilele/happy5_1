package com.example.happy5_1.entity;

public class GouEntity {
//    val id: Int,//购物车单项商品ID
//    val goodsId:Int,//具体商品ID
//    val goodsDesc: String,//商品描述
//    val goodsIcon: String,//商品图片
//    val goodsPrice: Long,//商品价格
//    var goodsCount: Int,//商品数量
//    val goodsSku:String,//商品SKU
//    var isSelected:Boolean//是否选中
        private int id;
        private int goodsId;
        private String goodsDesc;//商品描述
        private String goodsIcon;//商品图片
        private Long goodsPrice;//商品价格
        private int goodsCount;//商品数量
        private String goodsSku;//商品SKU
        private Boolean isSelected;//是否选中

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsIcon() {
        return goodsIcon;
    }

    public void setGoodsIcon(String goodsIcon) {
        this.goodsIcon = goodsIcon;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
