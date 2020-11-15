package com.book;

import com.strategy.AlignStrategy;
import com.strategy.Context;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy strategy;

    public Paragraph(String name){
        this.text = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy strategy){
        this.strategy = strategy;
    }

    @Override
    public void print(){
        if(strategy != null){
            strategy.render(text, new Context());
            return;
        }
        System.out.println("Paragraph text: " + text);
    }
}
