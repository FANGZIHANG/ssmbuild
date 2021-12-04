import com.fang.pojo.Books;
import com.fang.servie.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = (BookService) context.getBean("BookServiceImpl");
        for (Books books : service.queryAllBook()) {
            System.out.println(books);
        }
    }
}
