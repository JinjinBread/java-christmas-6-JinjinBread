package christmas.domain;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void 메뉴의_카테고리_가져오기() {
        Category categoryByMenu = Category.getCategoryByMenu(Menu.ICE_CREAM);

        assertThat(categoryByMenu)
                .isEqualTo(Category.DESSERT);
    }

    @Test
    void 존재하지_않는_메뉴의_카테고리를_가져오면_예외() {
        assertThrows(IllegalArgumentException.class, () -> Category.getCategoryByMenu(Menu.NONE));
    }

    @Test
    void 메뉴의_카테고리가_맞는지_확인() {
        boolean isCategoryMenu = Category.isCategoryMenu(Menu.T_BONE_STEAK, Category.MAIN);

        assertThat(isCategoryMenu).isEqualTo(true);
    }

    @Test
    void 메뉴의_카테고리가_아닌지_확인() {
        boolean isCategoryMenu = Category.isCategoryMenu(Menu.T_BONE_STEAK, Category.DESSERT);

        assertThat(isCategoryMenu).isEqualTo(false);
    }

}