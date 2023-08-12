package kz.bitlab.G115springfirstproject.models;

import kz.bitlab.G115springfirstproject.enums.ItemStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder//for dynamic construction builder
public class Item {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private ItemStatus itemStatus;
}


