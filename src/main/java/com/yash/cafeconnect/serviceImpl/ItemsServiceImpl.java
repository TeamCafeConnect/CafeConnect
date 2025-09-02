package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.dao.ItemsDao;
import com.yash.cafeconnect.daoImpl.ItemsDaoImpl;
import com.yash.cafeconnect.entity.Items;
import com.yash.cafeconnect.service.ItemService;

public class ItemsServiceImpl  implements ItemService {

    private final ItemsDao itemsDao;
    public ItemsServiceImpl(){
        this.itemsDao = new ItemsDaoImpl();
    }
    
    @Override
    public void addItems(Items items) {

        if (items.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        itemsDao.addItems(items);

    }

    @Override
    public void updateItem(Items item) {
        if (item.getItemId() <= 0) {
            throw new IllegalArgumentException("Invalid Item ID");
        }
        itemsDao.updateItems(item);


    }

    @Override
    public Items getItemById(int ItemId) {

        return itemsDao.getItemById(ItemId);
    }

    @Override
    public void deleteItem(int ItemId) {
        if (ItemId <= 0) {
            throw new IllegalArgumentException("Invalid Item ID");
        }
        itemsDao.deleteItem(ItemId);

    }
}
