package news;

import lt.vtvpmc.Article;

import java.util.List;

public class ArticleCensored implements Article {

    private final String heading;
    private String brief;
    List<String> swearWords;


    ArticleCensored(String heading, String brief, List<String> swearWords) {
        this.swearWords = swearWords;
        this.heading = heading;
        this.brief = brief;
    }

    @Override
    public String getHeading() {
        return this.heading;
    }

    @Override
    public String getBrief() {
        for (String s : swearWords) {
            if (brief.contains(s)) {
                brief = brief.replaceAll(s, "***");
            }
        }
        return this.brief;
    }

}
