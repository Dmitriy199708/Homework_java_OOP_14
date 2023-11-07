package org.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    Product product1 = new Product(1, "Хлеб", 100);
    Product product2 = new Product(33, "Шины", 5_000);
    Product product3 = new Product(3, "Макароны", 80);

    @Test
    public void removingANonExistentId() {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            shopRepository.removeById(4);
        });
    }
    @Test
    public void removeExistingId() {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.removeById(3);

        Product[] expected = { product1, product2};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected,actual);


    }
}
