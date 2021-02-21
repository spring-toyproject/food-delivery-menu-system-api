package com.fooddelivery.domain.menu.rdb.menu.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.fooddelivery.domain.menu.rdb.menu.dto.MenuEntityDTO;
import com.fooddelivery.domain.menu.rdb.menu.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MenuEntityTests {

  @Autowired
  private MenuRepository menuRepository;

  @Test
  public void 메뉴_엔티티를_생성합니다() {
    //given
    MenuEntity menu_name_with_less_20;
    MenuEntity menu_name_with_equal_20;

    String string_with_less_20 = "햄버거";
    String string_with_equal_20 = "가가가가가나나나나나다다다다다라라라라라";

    //when
    menu_name_with_less_20 = new MenuEntity(string_with_less_20, 0L, "", "");
    menu_name_with_equal_20 = new MenuEntity(string_with_equal_20, 0L, "", "");

    menuRepository.save(menu_name_with_less_20);
    menuRepository.save(menu_name_with_equal_20);

    //then
    MenuEntityDTO menu_dto_with_less_20 = menu_name_with_less_20.toDTO();
    MenuEntityDTO menu_dto_with_equal_20 = menu_name_with_equal_20.toDTO();

    assertAll(
        () -> assertEquals(string_with_less_20, menu_dto_with_less_20.name),
        () -> assertEquals(string_with_equal_20, menu_dto_with_equal_20.name)
    );
  }

  @Test
  public void 메뉴_이름_최대_글자는_20글자_입니다() {
    //given
    String string_with_more_20 = "가가가가가나나나나나다다다다다라라라라라마";

    MenuEntity menu_name_with_more_20 = new MenuEntity(string_with_more_20, 0L, "", "");

    //when
    Exception exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
      menuRepository.save(menu_name_with_more_20);
    });

    //then
    assertTrue(exception.getMessage().contains("could not execute statement"));
  }

}
