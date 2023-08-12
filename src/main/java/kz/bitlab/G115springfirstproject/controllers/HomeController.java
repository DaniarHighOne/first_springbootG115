package kz.bitlab.G115springfirstproject.controllers;

import kz.bitlab.G115springfirstproject.db.DBManager;
import kz.bitlab.G115springfirstproject.enums.ItemStatus;
import kz.bitlab.G115springfirstproject.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model) {
        List<Item> items = DBManager.getItems();
        model.addAttribute("stuff", items);
        return "home";
    }

    @PostMapping("/add-item")
    public String addItem(Item item) {
        DBManager.addItem(item);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        Item item = DBManager.getItemById(id);
        model.addAttribute("zat", item);
        model.addAttribute("statuses", ItemStatus.values());
        return "details";
    }

    @PostMapping("/edit-item")
    public String editItem(@RequestParam(name = "item_id") Long id,
                           @RequestParam(name = "item_name") String name,
                           @RequestParam(name = "item_description") String description,
                           @RequestParam(name = "item_price") Integer price,
                           @RequestParam(name = "item_status") ItemStatus status) {
        DBManager.editItem(id, name, description, price, status);
        return "redirect:/";
    }

}
