package com.jun.controller;

import com.jun.pojo.Books;
import com.jun.pojo.PageResult;
import com.jun.service.BooksService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @create 2020/7/4 - 21:16
 */
@Controller
public class BooksController {
    @Autowired
    private BooksService booksServiceImpl;

    /**
     * 分页显示书籍信息
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("/showBooks")
    public String list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "6") Integer size,
            Model model){
        PageResult<Books> book = booksServiceImpl.findByPage(page, size);
        model.addAttribute("list",book.getList());
        model.addAttribute("currPage", book.getCurrPage());
        model.addAttribute("totalPage", book.getTotalPage());
        model.addAttribute("totalCount", book.getTotalCount());
        model.addAttribute("pageSize", book.getPageSize());
        return "allBook";
    }

    /**
     * 展示新增页面
     * @return
     */
    @RequestMapping("/showAddBook")
    public String toAddBook(){
        return "toAddBook";
    }

    /**
     * 新增书籍
     * @param books
     * @return
     */
    @RequestMapping("/addBook")
    public String insertBook(Books books){
        booksServiceImpl.insertBook(books);
        return "redirect:/showBooks";
    }

    /**
     * 展示修改页面
     * @param bookID
     * @param model
     * @return
     */
    @RequestMapping("/showUpdateBook")
    public String updateBook(@RequestParam("id") int bookID,Model model){
        Books book = booksServiceImpl.queryBookById(bookID);
        model.addAttribute("boos",book);
        return "toUpdateBook";
    }

    /**
     * 修改书籍
     * @param books
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        booksServiceImpl.updateBook(books);
        return "redirect:/showBooks";
    }

    /**
     * 删除书籍
     * @param bookID
     * @return
     */
    @RequestMapping("/del/{id}")
    public String deleteBook(@PathVariable("id") int bookID){
        booksServiceImpl.deleteBookById(bookID);
        return "redirect:/showBooks";
    }

    /**
     * 根据bookName进行模糊查询
     * @param bookName
     * @param model
     * @return
     */
    @RequestMapping("/selectBook")
    public String selectBookByName(String bookName,Model model){
        List<Books> list = booksServiceImpl.selectBookByName(bookName);

        if(list == null){
           list = booksServiceImpl.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
