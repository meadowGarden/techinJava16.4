package news;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewServiceImplSwearFiltering implements NewsService {

    private NewsServiceImpl newsService = new NewsServiceImpl();
    private List<Article> allArticles = newsService.getArticles();

    @Override
    public List<Article> getArticles() {

        List<String> swearWords = Arrays.asList("rupūs miltai", "velniai rautų", "velnias", "velniais");

        List<Article> filteredArticles = new ArrayList();
        for (Article a : allArticles) {
            for (String s : swearWords) {
                if (a.getHeading().indexOf(s) < 1) {
                    break;
                }
                filteredArticles.add(a);
            }
        }
        return filteredArticles;
    }
}
