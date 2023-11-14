package christmas.domain.menu;


public enum GiveawayMenu {

    GIVEAWAY_MENU_1(Menu.CHAMPAGNE, 1);

    private final Menu menu;
    private final int menuCount;

    GiveawayMenu(Menu menu, int menuCount) {
        this.menu = menu;
        this.menuCount = menuCount;
    }

    public String getMenuName() {
        return menu.getMenuName();
    }

    public int getMenuCount() {
        return menuCount;
    }

    public int getGiveawayPrice() {
        return menu.calculatePrice(menuCount);
    }
}
