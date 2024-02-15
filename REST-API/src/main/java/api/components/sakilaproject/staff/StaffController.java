package api.components.sakilaproject.staff;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.country.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private final StaffService staffService;

    public StaffController (StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String getAllStaff() throws JsonProcessingException {
        return staffService.readStaff();
    }
}
