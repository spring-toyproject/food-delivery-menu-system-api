package com.fooddelivery.domain.menu.rdb.menu.entity;

import com.fooddelivery.domain.menu.rdb.menu.dto.MenuEntityDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Table(name = "menu")
@Entity
public class MenuEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20, nullable = false)
  @ColumnDefault("")
  private String name;

  @Column(nullable = false)
  @ColumnDefault("0")
  private Long price;

  @Column(length = 30, nullable = false)
  @ColumnDefault("")
  private String composition;

  @Column(length = 80, nullable = false)
  @ColumnDefault("")
  private String description;

  public MenuEntity() {
  }

  public MenuEntity(String name, Long price, String composition, String description) {
    this.name = name;
    this.price = price;
    this.composition = composition;
    this.description = description;
  }

  public MenuEntityDTO toDTO() {
    MenuEntityDTO menuEntityDTO = new MenuEntityDTO(0L, "", 0L, "", "");
    return menuEntityDTO;
  }

}
