package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum Category {

    APPETIZER("에피타이저", Arrays.asList(Menu.BUTTON_MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN("메인", Arrays.asList(Menu.T_BONE_STEAK, Menu.BARBECUE_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    DRINK("음료", Arrays.asList(Menu.ZERO_COLA, Menu.RED_WINE, Menu.CHAMPAGNE));

    private final String categoryName;
    private final List<Menu> menus;

    Category(String categoryName, List<Menu> menus) {
        this.categoryName = categoryName;
        this.menus = menus;
    }

    public static Category getCategoryByMenu(Menu menu) {
        return Stream.of(Category.values())
                .filter(category -> category.menus.contains(menu))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다."));
    }

    public static boolean isCategoryMenu(Menu menu, Category category) {
        Category categoryByMenu = getCategoryByMenu(menu);
        return categoryByMenu.equals(category);
    }

}
