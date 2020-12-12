package com.services;

import com.interfaces.Element;
import com.interfaces.Visitor;
import com.model.*;

public class PrintContentVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Authors: ");
        for (Author a : book.getAuthors()) {
            System.out.println("Author: " + a.getName());
        }
        System.out.println();
        for (Element e : book.getContent()) {
            castVisitor(e);
        }
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
        for (Element e : section.getElements())
            castVisitor(e);
    }

    @Override
    public void visit(Paragraph paragraph) {
        if (paragraph.getStrategy() != null) {
            paragraph.getStrategy().render(paragraph.getText(), new Context());
            return;
        }
        System.out.println("Paragraph text: " + paragraph.getText());
    }

    @Override
    public void visit(ImageProxy proxy) {
        visit(proxy.loadImage());
        proxy.getDimension().printDimension();
    }

    @Override
    public void visit(Image image) {
        System.out.println("ImageName : " + image.getImageName());
    }

    @Override
    public void visit(Table table) {
        System.out.println("Table name: " + table.getName());
    }

    @Override
    public void visit(TableOfContent content) {
        System.out.println("Table of content: ---");
    }

    private void castVisitor(Element e) {
        if (e instanceof Paragraph) {
            visit((Paragraph) e);
        } else if (e instanceof ImageProxy) {
            visit((ImageProxy) e);
        } else if (e instanceof Image) {
            visit((Image) e);
        } else if (e instanceof TableOfContent) {
            visit((TableOfContent) e);
        } else if (e instanceof Section) {
            visit((Section) e);
        } else if (e instanceof Table) {
            visit((Table) e);
        }
    }
}
