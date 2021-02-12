package com.fooddelivery.domain.menu.service;

import com.fooddelivery.domain.rdb.menu.service.MenuRDBService;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private final MenuRDBService menuRDBService;

    public MenuService(MenuRDBService menuRDBService) {
        this.menuRDBService = menuRDBService;
    }
}
