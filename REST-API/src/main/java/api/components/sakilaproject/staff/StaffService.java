package api.components.sakilaproject.staff;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    @Autowired
    private final StaffRepository staffRepo;
    public StaffService (StaffRepository staffRepo){
        this.staffRepo = staffRepo;
    }

    public String readStaff() throws JsonProcessingException {
        List<Staff> objectStaff = staffRepo.findAll();
        List<String> staffList = new ArrayList<String>();

        for(Staff staff : objectStaff){
            JSONObject jo = JSONFix.fixOrder(staff, JsonViews.Staff.class);
            staffList.add(jo.toString());
        }
        return staffList.toString();
    }
}
