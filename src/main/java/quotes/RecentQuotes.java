package quotes;

public class RecentQuotes {
    String[] tag;
    String author;
    String likes;
    String text;

    public void quotes(String tag[], String author, String likes, String text){
        this.tag=tag;
        this.author=author;
        this.likes=likes;
        this.text=text;
    }


    @Override
    public String toString() {
        return "RecentQuotes{" +
                "tag='" + tag + '\'' +
                ", author='" + author + '\'' +
                ", likes='" + likes + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
