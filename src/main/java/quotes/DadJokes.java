package quotes;

public class DadJokes {

    private String text;

    public void BuildAJoke(String fallback){
        this.text = fallback;
        System.out.println(text);
    }


}
