package com.model;

import com.interfaces.Element;
import com.interfaces.Visitor;
import com.services.AlignStrategy;
import com.services.Context;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(force = true)
public class Paragraph extends Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    @Transient
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
