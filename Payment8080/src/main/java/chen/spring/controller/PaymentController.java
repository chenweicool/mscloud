package chen.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;
    @GetMapping(value = "/payment/hello")
    public String getHelloWorld(){
        return "hello"+serverPort;
    }
}
