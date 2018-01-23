package com.dp3.web.controller;

import com.dp3.domain.Order;
import com.dp3.service.OrderService;
import com.dp3.printable.Printer;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/printOrder", produces = "application/pdf")
    public ResponseEntity<byte[]> getPDF(@ModelAttribute Order order) throws DocumentException {
        Printer printService = new Printer(order);
        return printService.print();
    }

}
