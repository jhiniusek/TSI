package api.components.sakilaproject.category;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepo;
    public CategoryService (CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public String readCategories() throws JsonProcessingException {
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
