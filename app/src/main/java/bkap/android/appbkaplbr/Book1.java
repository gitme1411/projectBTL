package bkap.android.appbkaplbr;

import java.util.Date;

public class Book1 {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int numofpages;
    private double price;
    private Date datepost;

    public Book1() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Book1(int id, String title, String author, String publisher, int numofpages, double price, Date datepost) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numofpages = numofpages;
        this.price = price;
        this.datepost = datepost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumofpages() {
        return numofpages;
    }

    public void setNumofpages(int numofpages) {
        this.numofpages = numofpages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDatepost() {
        return datepost;
    }

    public void setDatepost(Date datepost) {
        this.datepost = datepost;
    }

}
