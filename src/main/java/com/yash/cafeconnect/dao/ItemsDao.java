package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Items;

public interface ItemsDao {

    void addItems(Items item);

    void updateItems(Items item);

    Items getItemById(int ItemId);

    void deleteItem(int ItemId);


}
