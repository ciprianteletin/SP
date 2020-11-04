package com.book;

public class ImageProxy implements Element {
    private String url;
    private int dimension;
    private Image realImage;

    public ImageProxy(String url){
        this.url = url;
    }

    private Image loadImage(){
        if(realImage == null){
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }
}
