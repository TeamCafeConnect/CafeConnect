package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.dao.MenuDao;
import com.yash.cafeconnect.daoImpl.MenuDaoImpl;
import com.yash.cafeconnect.entity.Menu;
import com.yash.cafeconnect.service.MenuService;


public class MenuServiceImpl implements MenuService {

    private MenuDao menuDao = new MenuDaoImpl();

    @Override
    public void addMenu(Menu menu) {

        if (menu.getDishName() == null || menu.getDishName().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty");
        }

        Menu existingMenu = menuDao.getMenuById(menu.getMenuId());
        if (existingMenu != null) {
            throw new IllegalStateException("Menu with this ID already exists");
        }
        menuDao.addMenu(menu);

    }

    @Override
    public Menu getMenuById(int MenuId) {
        return menuDao.getMenuById(MenuId);
    }

    @Override
    public void updateMenu(Menu menu) {
        if (menu.getDishName() == null || menu.getDishName().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty");
        }
        Menu existingMenu = menuDao.getMenuById(menu.getMenuId());
        if (existingMenu == null) {
            throw new IllegalStateException("Menu with this ID does not exist");
        }
        menuDao.updateMenu(menu);
    }

    @Override
    public void deleteMenu(int MenuId) {
        Menu existingMenu = menuDao.getMenuById(MenuId);
        if (existingMenu == null) {
            throw new IllegalStateException("Menu with this ID does not exist");
        }
        menuDao.deleteMenu(MenuId);

    }
}
