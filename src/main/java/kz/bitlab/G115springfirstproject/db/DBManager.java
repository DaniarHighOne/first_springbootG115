package kz.bitlab.G115springfirstproject.db;

import kz.bitlab.G115springfirstproject.enums.ItemStatus;
import kz.bitlab.G115springfirstproject.models.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static kz.bitlab.G115springfirstproject.enums.ItemStatus.IN_SHOP;
import static kz.bitlab.G115springfirstproject.enums.ItemStatus.IN_STOCK;
import static kz.bitlab.G115springfirstproject.enums.ItemStatus.ON_DELIVERY;


public class DBManager {

    @Getter
    static List<Item> items = new ArrayList<>();

    private static Long id = 6L;

    static {
        items.add(new Item(1L, "Macbook", "512gb",500000, IN_STOCK));
        items.add(new Item(2L, "HP", "512gb",100000, IN_SHOP));
        items.add(new Item(3L, "Dell", "512gb",900000,ON_DELIVERY));
        Item item = Item.builder()
                .id(4L)
                .name("Apple")
                .description("1 tb")
                .price(700000)
                .itemStatus(ON_DELIVERY)
                .build();
                items.add(item);
    }

    public static void addItem(Item item) {
        item.setId(id);
        id++;
        items.add(item);
    }

    public static Item getItemById(Long id) {
        return items.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public static void editItem(Long id, String name, String description, Integer price, ItemStatus status) {
        Item item = getItemById(id);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setItemStatus(status);
    }
}
