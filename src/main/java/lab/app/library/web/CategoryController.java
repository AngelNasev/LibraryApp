package lab.app.library.web;

import lab.app.library.model.enumerations.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping({"/api/categories"})
public class CategoryController {

    @GetMapping
    public List<Category> findAll(){
        return Arrays.asList(Category.values());
    }
}
