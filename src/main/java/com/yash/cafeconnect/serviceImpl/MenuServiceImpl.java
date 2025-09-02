package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.dao.MenuDao;
import com.yash.cafeconnect.daoImpl.MenuDaoImpl;
import com.yash.cafeconnect.entity.Menu;
import com.yash.cafeconnect.service.MenuService;


public class MenuServiceImpl implements MenuService {

    private final MenuDao menuDao;


    public MenuServiceImpl() {
        this.menuDao = new MenuDaoImpl();
    }

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
        if (menu.getMenuId() <= 0) {
            throw new IllegalArgumentException("Menu ID must be positive for update");
        }
        if (menu.getDishName() == null || menu.getDishName().trim().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty");
        }
        menuDao.updateMenu(menu);
    }

    @Override
    public void deleteMenu(int MenuId) {
        if (MenuId <= 0) {
            throw new IllegalArgumentException("Menu ID must be positive for delete");
        }
        menuDao.deleteMenu(MenuId);
    }

    }

