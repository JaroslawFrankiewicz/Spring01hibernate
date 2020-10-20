package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    @RequestMapping(value = "/category/all/{id}")
    @ResponseBody
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
