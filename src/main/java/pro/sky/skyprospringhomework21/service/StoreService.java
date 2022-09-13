package pro.sky.skyprospringhomework21.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhomework21.componenet.Basket;
import pro.sky.skyprospringhomework21.model.Item;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final Basket basket;
    private final Map<Integer, Item> items;

    public StoreService(Basket basket) {
        this.basket = basket;
        this.items = Map.of(
                1, new Item(1, "Книга", 35),
                2, new Item(2, "Ноутбук", 35000),
                3, new Item(3, "Смартфон", 25000)
        );
    }

    public void add(List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(items::get)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );
    }

    public List<Item> get() {
        return basket.get();
    }

}
