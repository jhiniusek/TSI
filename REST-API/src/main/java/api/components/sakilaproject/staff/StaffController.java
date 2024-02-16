package api.components.sakilaproject.staff;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
