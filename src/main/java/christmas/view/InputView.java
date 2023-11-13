package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String NUMERIC_REGX = "\\d+";

    public int readDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = deleteBlank(Console.readLine());
            validateNumeric(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            return readDate();
        }
    }

    public String readOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String orderMenu = deleteBlank(Console.readLine());
        return orderMenu;
    }

    private String deleteBlank(String input) {
        return input.replaceAll(BLANK, EMPTY);
    }

    private void validateNumeric(String input) {
        Matcher matcher = Pattern.compile(NUMERIC_REGX).matcher(input);
        if (!matcher.matches())
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
    }

}
