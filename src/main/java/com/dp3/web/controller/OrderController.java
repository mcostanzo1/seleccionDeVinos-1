package com.dp3.web.controller;

import com.dp3.domain.Order;
import com.dp3.domain.OrderStatus;
import com.dp3.service.OrderService;
import com.dp3.printable.Printer;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="/")
    public ModelAndView getOrderView(Model model) {
        model.addAttribute("createdOrders", orderService.getOrdersByStatus(OrderStatus.CREATED));
        model.addAttribute("inProgressOrders", orderService.getOrdersByStatus(OrderStatus.IN_PROGRESS));
        model.addAttribute("finishedOrders", orderService.getOrdersByStatus(OrderStatus.FINISHED));

        return new ModelAndView("orderslist");
    }

    @PostMapping(value="/details")
    public ModelAndView viewDetails(Model model, @RequestParam("orderId") Integer orderId) {
        orderService.progressOrder(orderId);
        return getOrderView(model);
    }

    @GetMapping(value = "/printOrder", produces = "application/pdf")
    public ResponseEntity<byte[]> getPDF(@ModelAttribute Order order) throws DocumentException {
        Printer printService = new Printer(order);
        return printService.print();
    }

}
