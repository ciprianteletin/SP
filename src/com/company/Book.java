package com.company;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<String> paragraphs;
    private List<String> images;
    private List<String> tables;
    private String title;

    public Book(String title){
        this.title = title;
        this.paragraphs = new ArrayList<>();
        this.images = new ArrayList<>();
        this.tables = new ArrayList<>();
    }

    public void createNewParagraph(String paragraph){
        this.paragraphs.add(paragraph);
    }

    public void createNewImage(String image){
        this.images.add(image);
    }

    public void createNewTable(String table){
        this.tables.add(table);
    }

    public void print(){
        System.out.println("-----Title-----");
        System.out.println(title);
        System.out.println("-----Paragraphs-----");
        System.out.println(paragraphs.toString());
        System.out.println("-----Images-----");
        System.out.println(images.toString());
        System.out.println("-----Tables-----");
        System.out.println(tables.toString());
    }
}
