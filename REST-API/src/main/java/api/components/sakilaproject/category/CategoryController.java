package api.components.sakilaproject.category;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    public String getAllCategories() throws JsonProcessingException {
        List<Category> objectCategories = categoryRepo.findAll();
        List<String> categories = new ArrayList<String>();

        for(Category category : objectCategories){
            JSONObject jo = JSONFix.fixOrder(category, JsonViews.Category.class);
            categories.add(jo.toString());
        }
        System.out.println(categories);
        return categories.toString();
    }
}
