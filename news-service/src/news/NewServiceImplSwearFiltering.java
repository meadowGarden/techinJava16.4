package news;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewServiceImplSwearFiltering implements NewsService {

    private List<Article> allArticles;

    public NewServiceImplSwearFiltering(NewsServiceImpl newsService) {
        this.allArticles = newsService.getArticles();
    }

    @Override
    public List<Article> getArticles() {

        List<String> swearWords = Arrays.asList("rupūs miltai", "velniai rautų", "velnias", "velniais");

        List<Article> filteredArticleHeads = new ArrayList<>();
        boolean isClean;
        for (Article a : allArticles) {
            isClean = true;
            for (String s : swearWords) {
                if (a.getHeading().toLowerCase().contains(s)) {
                   isClean = false;
                   break;
                }
            }
            if (!filteredArticleHeads.contains(a.getHeading()) && isClean) {
                filteredArticleHeads.add(a);
            }
        }

        List<Article> filteredArticleHeadsAndBriefs = new ArrayList<>();
        for (Article a : filteredArticleHeads) {
            filteredArticleHeadsAndBriefs.add(
            new ArticleCensored(a.getHeading(), a.getBrief(), swearWords));
        }

        return filteredArticleHeadsAndBriefs;

//        List<Article> filteredArticles = allArticles.stream()
//                .filter(a -> swearWords.stream()
//                        .noneMatch(s -> a.getHeading().toLowerCase().contains(s)))
//                .filter(a -> allArticles.stream()
//                        .noneMatch(article -> article.getHeading().equals(a.getHeading())))
//                .toList();

//        List<Article> filteredArticles = allArticles.stream()
//                .filter(a -> swearWords.stream()
//                        .noneMatch(s -> a.getHeading().toLowerCase().contains(s)))
//                .filter(a -> !allArticles.stream()
//                        .anyMatch(article -> article.getHeading().equals(a.getHeading())))
//                .collect(Collectors.toList());

//        return filteredArticles;

    }
}
