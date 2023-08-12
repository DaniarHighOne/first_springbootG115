package kz.bitlab.G115springfirstproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ItemStatus {
    IN_SHOP("ITEM STATUS: IN SHOP"),//here we see it like a message which get by annotation
    ON_DELIVERY("ITEM STATUS: ON DELIVERY"),
    IN_STOCK("ITEM STATUS: IN STOCK");
    @Getter
    private final String message;//get the status as a message
}
