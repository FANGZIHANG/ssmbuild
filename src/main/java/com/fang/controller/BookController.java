package com.fang.controller;

import com.fang.pojo.Books;
import com.fang.servie.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //    方法一：查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allbook";
    }

    //方法二：添加书籍
    @RequestMapping("toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //方法三：修改书籍
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookId(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books books) {
        System.out.println(books);
        bookService.updateBook(books);
        bookService.queryBookId(books.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    //方法四：删除书籍
    @RequestMapping("/del/{bookId}")
    public String DeleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}
