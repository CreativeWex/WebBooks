package web.digitallibrary.contollers;
/*
    =====================================
    @project DigitalLibrary
    @created 21/01/2023    
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.digitallibrary.DAO.BookDAO;
import web.digitallibrary.DAO.OrderDAO;
import web.digitallibrary.model.Order;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderDAO orderDAO;
    private final BookDAO bookDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO, BookDAO bookDAO) {
        this.orderDAO = orderDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("orderList", orderDAO.getAll());
        return "orders/showAll";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", orderDAO.getById(id));
        return "orders/showById";
    }

    @PostMapping()
    public String add(@ModelAttribute("order") @Valid Order order) {
        orderDAO.save(order);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.setFree(orderDAO.getById(id).getBookId());
        orderDAO.delete(id);
        return "redirect:/orders";
    }
}
