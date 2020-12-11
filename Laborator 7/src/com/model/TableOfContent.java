package com.model;

public class TableOfContent implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    //Nothing here in this lab
}
