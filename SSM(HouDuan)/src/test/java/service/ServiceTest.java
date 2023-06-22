package service;


import com.dome.config.SpringConfig;
import com.dome.domain.News;
import com.dome.domain.user_inf;
import com.dome.service.NewsService;
import com.dome.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;

    @Test
    public void testSave(){
        user_inf userInf = new user_inf();
        userInf.setId(1);
        userInf.setPassword("123");
        userInf.setUsername("abc");
        userInf.setPhone("110");
        System.out.println(userService.save(userInf));
    }
    @Test
    public void testSave2(){
        user_inf userInf = new user_inf();
        userInf.setId(1);
        userInf.setPassword("123");
        userInf.setUsername("abc");
        userInf.setPhone("110");
        System.out.println(userService.isExist(userInf));
    }

    @Test
    public  void Testupdate(){
        user_inf userInf = new user_inf();
        userInf.setId(8);
        userInf.setPassword("update");
        userInf.setUsername("abaac");
        userInf.setPhone("123123");
        userService.update(userInf);

    }
    @Test
    public void SaveNews(){
        News news = new News();
        news.setAuther("李白");
        news.setConter("诗圣");
        news.setDate("20230621");
        newsService.save(news);
    }

    @Test
    public void testGetAll(){
        System.out.println(userService.getAll());
    }
}
