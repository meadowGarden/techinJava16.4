package news;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        NewsServiceImpl newsService = new NewsServiceImpl();
        List<Article> newsArticles = newsService.getArticles();

        NewServiceImplSwearFiltering newsServiceFiltered = new NewServiceImplSwearFiltering();
        List<Article> newsArticlesFiltered = newsServiceFiltered.getArticles();

//        for (Article a : newsArticles) {
//            System.out.println(a.getHeading());
//        }
//        System.out.println("-------");

        newsArticles.stream()
                .map(a -> a.getHeading())
                .forEach(a -> System.out.println(a));
                System.out.println("-------");

        newsArticlesFiltered.stream()
                .map(a -> a.getHeading())
                .forEach(a -> System.out.println(a));







    }
}
