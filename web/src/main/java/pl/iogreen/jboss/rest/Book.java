package pl.iogreen.jboss.rest;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

    private String name;
    private String author;

    public Book() {

    }

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
