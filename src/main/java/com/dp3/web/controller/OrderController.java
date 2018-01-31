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

import java.util.List;

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

    @GetMapping(value = "/all/")
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @PostMapping(value="/{id}/progress")
    public ModelAndView progressOrder(@PathVariable("id") Integer orderId) {
        orderService.progressOrder(orderId);
        return new ModelAndView("redirect:/orders/");
    }

    @PostMapping(value="/{id}/cancel")
    public ModelAndView cancelOrder(Model model, @PathVariable("id") Integer orderId) {
        orderService.cancelOrder(orderId);
        return new ModelAndView("redirect:/orders/");
    }

    @GetMapping(value = "/{id}/print", produces = "application/pdf")
    public ResponseEntity<byte[]> getPDF(@PathVariable("id") Integer orderId) throws DocumentException {
        Order order = orderService.findOne(orderId);
        Printer printService = new Printer(order);
        return printService.print();
    }

}
