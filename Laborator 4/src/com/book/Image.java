package com.book;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String imageName;

    public Image(String name){
        this.imageName = name;
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public void print() {
        System.out.println("ImageName : " + imageName);
    }
}
