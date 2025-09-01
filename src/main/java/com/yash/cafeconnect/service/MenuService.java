package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Menu;

public interface MenuService {

    void addMenu(Menu menu);

    Menu getMenuById(int MenuId);

    void updateMenu (Menu menu);

    void deleteMenu(int MenuId);


}
