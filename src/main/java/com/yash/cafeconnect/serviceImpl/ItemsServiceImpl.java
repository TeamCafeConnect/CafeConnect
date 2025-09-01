package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.dao.ItemsDao;
import com.yash.cafeconnect.daoImpl.ItemsDaoImpl;
import com.yash.cafeconnect.entity.Items;
import com.yash.cafeconnect.service.ItemService;

public class ItemsServiceImpl  implements ItemService {

    private ItemsDao itemsDao = new ItemsDaoImpl();
    @Override
    public void addItems(Items items) {

        if (items.getItemQuantity() <= 0) {
            throw new IllegalArgumentException("Item quantity must be greater than zero");
        }
        if (items.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (items.getDescription() == null || items
                .getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }


        itemsDao.addItems(items);

    }

    @Override
    public void updateItem(Items item) {
        if (itemsDao.getItemById(item.getItemId()) == null) {
            throw new IllegalStateException("Item with this Id does not exist");
        }
        itemsDao.updateItems(item);


    }

    @Override
    public Items getItemById(int ItemId) {

        return itemsDao.getItemById(ItemId);
    }

    @Override
    public void deleteItem(int ItemId) {
        if (itemsDao.getItemById(ItemId) == null) {
            throw new IllegalArgumentException("Id does not exist");
        }
        itemsDao.deleteItem(ItemId);

    }
}
