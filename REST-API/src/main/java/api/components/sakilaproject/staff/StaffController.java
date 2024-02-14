package api.components.sakilaproject.staff;

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
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepo;

    @GetMapping
    public String getAllStaff() throws JsonProcessingException {
        List<Staff> objectStaff = staffRepo.findAll();
        List<String> staffList = new ArrayList<String>();

        for(Staff staff : objectStaff){
            JSONObject jo = JSONFix.fixOrder(staff, JsonViews.Staff.class);
            staffList.add(jo.toString());
        }
        return staffList.toString();
    }
}
