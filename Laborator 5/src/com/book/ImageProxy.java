package com.book;

import com.utils.Dimension;

public class ImageProxy implements Element {
    private String url;
    private Dimension dimension;
    private Image realImage;

    public ImageProxy(String url, Dimension dimension){
        this.url = url;
        this.dimension = dimension;
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
        dimension.printDimension();
    }
}
