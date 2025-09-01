package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Cafe;
import com.yash.cafeconnect.entity.Menu;

public interface MenuDao {

    void addMenu(Menu menu);

    Menu getMenuById(int MenuId);

    void updateMenu(Menu menu);

    void deleteMenu(int menuId);


    }
