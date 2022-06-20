package com.example.springdatajpasliceissue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemIntegrationTest {
    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    public void setup() {
        itemRepository.deleteAll();
        var items = new ArrayList<Item>(100);
        for (int i = 0; i < 100; i++) {
            items.add(new Item(null, UUID.randomUUID().toString(), null, null));
        }
        itemRepository.saveAll(items);
    }

    @Test
    void shouldReturnItemSliceInsteadOfPage() {
        var itemSlice = itemRepository.findAll(Pageable.ofSize(10));
        assertThat(itemSlice).isInstanceOf(SliceImpl.class);
    }
}