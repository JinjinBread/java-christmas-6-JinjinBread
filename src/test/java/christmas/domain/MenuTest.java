package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void 존재하는_메뉴인지_확인() {
        boolean existMenu = Menu.existMenu("타파스");
        assertThat(existMenu).isEqualTo(true);
    }

    @Test
    void 존재하지_않는_메뉴인지_확인() {
        boolean existMenu = Menu.existMenu("없음");
        assertThat(existMenu).isEqualTo(false);
    }
    
}