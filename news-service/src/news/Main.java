package news;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        NewsServiceImpl newsService = new NewsServiceImpl();
        List<Article> newsArticles = newsService.getArticles();
        newsArticles.stream()
                .map(a -> a.getHeading())
                .forEach(a -> System.out.println(a));
        newsArticles.stream()
                .map(a -> a.getBrief())
                .forEach(a -> System.out.println(a));
        System.out.println("-------");

        NewServiceImplSwearFiltering newsServiceFiltered = new NewServiceImplSwearFiltering(newsService);
        List<Article> newsArticlesFiltered = newsServiceFiltered.getArticles();
        newsArticlesFiltered.stream()
                .map(a -> a.getHeading())
                .forEach(a -> System.out.println(a));

        newsArticlesFiltered.stream()
                .map(a -> a.getBrief())
                .forEach(a -> System.out.println(a));

    }
}
