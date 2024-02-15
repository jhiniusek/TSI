package api.components.sakilaproject.payment;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.inventory.InventoryRepository;
import api.components.sakilaproject.rental.Rental;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepo;
    public PaymentService (PaymentRepository paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    public String readPayments() throws JsonProcessingException {
        List<Payment> objectPayments = paymentRepo.findAll();
        List<String> payments = new ArrayList<String>();

        for(Payment payment : objectPayments){
            JSONObject jo = JSONFix.fixOrder(payment, JsonViews.Payment.class);
            payments.add(jo.toString());
        }
        return payments.toString();
    }


}