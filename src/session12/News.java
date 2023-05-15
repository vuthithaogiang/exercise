package session12;

import java.util.ArrayList;
import java.util.Objects;


class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    private ArrayList<Float> rateList = new ArrayList<>();

    public News() {

    }

    public News(int id, String title, String publishDate, String author, String content){
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        News news = (News) o;
        return Objects.equals(id, news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void Display(){
        System.out.println("=====> Information's News <======");
        System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20f\n",
            this.getId(),  this.getTitle(), this.getPublishDate(), this.getAuthor(), this.getContent(), this.getAverageRate());
    }

    public void Calculate() {
        float total = 0;
        int size = this.rateList.size();
        for(int i = 0; i < size ; i ++ ) {
            total += this.rateList.get(i);
        }
        this.averageRate = total/size;
        //this.averageRate = Math.round(total/size);
    }

    public void InputRate(float rating) {
        if(rating >= 1 && rating <= 5){
            this.rateList.add(rating);
            this.Calculate();
        }
        else{
            System.out.println("Please enter rating in [1, 5]");
        }
    }
}
