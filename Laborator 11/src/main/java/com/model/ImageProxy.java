package com.model;

import com.interfaces.Element;
import com.interfaces.Visitor;
import com.utils.Dimension;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@NoArgsConstructor(force = true)
@Table(name = "image_proxy")
public class ImageProxy extends Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    @Transient
    private Dimension dimension;
    @Transient
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
