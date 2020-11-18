package com.model;

import com.services.AlignStrategy;
import com.services.Context;

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

    public AlignStrategy getStrategy(){
        return this.strategy;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
