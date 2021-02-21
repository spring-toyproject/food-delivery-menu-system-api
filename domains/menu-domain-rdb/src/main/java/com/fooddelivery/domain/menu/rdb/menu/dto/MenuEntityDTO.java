package com.fooddelivery.domain.menu.rdb.menu.dto;

import com.fooddelivery.domain.menu.rdb.menu.entity.MenuEntity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

public class MenuEntityDTO {
  public Long id;
  public String name;
  public Long price;
  public String composition;
  public String description;

  public MenuEntityDTO(Long id, String name, Long price, String composition, String description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.composition = composition;
    this.description = description;
  }

  public MenuEntity toEntity() {
    MenuEntity menuEntity = new MenuEntity(name, price, composition, description);
    return menuEntity;
  }
}
