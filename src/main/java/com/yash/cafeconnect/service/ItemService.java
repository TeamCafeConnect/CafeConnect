package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Items;

public interface ItemService {

    void addItems(Items items);

    void updateItem(Items items);

    Items getItemById(int ItemId);

    void deleteItem(int ItemId);
}
