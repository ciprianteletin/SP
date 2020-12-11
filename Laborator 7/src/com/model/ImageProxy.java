package com.model;

import com.utils.Dimension;

public class ImageProxy implements Element {
    private String url;
    private Dimension dimension;
    private Image realImage;

    public ImageProxy(String url, Dimension dimension){
        this.url = url;
        this.dimension = dimension;
    }

    public ImageProxy(String url){
        this.url = url;
        this.dimension = new Dimension(460,460);
    }

    public Image loadImage(){
        if(realImage == null){
            realImage = new Image(url);
        }
        return realImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
