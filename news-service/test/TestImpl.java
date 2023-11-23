import lt.vtvpmc.BaseNewsServiceTest;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;
import news.NewServiceImplSwearFiltering;

public class TestImpl extends BaseNewsServiceTest {


    @Override
    protected NewsService getNewsService() {
        return new NewServiceImplSwearFiltering(new NewsServiceImpl());
    }
}
