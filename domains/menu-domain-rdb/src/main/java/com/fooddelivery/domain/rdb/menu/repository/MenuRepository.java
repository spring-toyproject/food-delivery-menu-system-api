package com.fooddelivery.domain.rdb.menu.repository;

import com.fooddelivery.domain.rdb.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
