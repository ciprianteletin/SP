package com.model;

import com.utils.ImageContent;
import com.utils.ImageContentFactory;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String imageName;
    private ImageContent content;
    private ImageContentFactory factory;

    public Image(String name){
        this.imageName = name;
        factory = new ImageContentFactory();
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public ImageContent getContent(){
        return this.content;
    }

    public void setContent(String type){
        content = factory.loadImage(type);
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
