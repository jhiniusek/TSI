package api.components.sakilaproject.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String getAllPayments() throws JsonProcessingException {
        return paymentService.readPayments();
    }

    @GetMapping("/byCustomerID/{id}")
    public String getPaymentsByCustomerID(@PathVariable("id") int custID) throws JsonProcessingException {
        return paymentService.readPaymentsByCustomerID(custID);
    }

    @GetMapping("/byCustomerName/{name}")
    public String getPaymentsByCustomerID(@PathVariable("name") String custName) throws JsonProcessingException {
        return paymentService.readRentalsByCustomerName(custName);
    }

    @GetMapping("/byStoreID/{id}")
    public String getPaymentByStoreID(@PathVariable("id") int storeID) throws JsonProcessingException {
        return paymentService.readPaymentsByStoreID(storeID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }
}
