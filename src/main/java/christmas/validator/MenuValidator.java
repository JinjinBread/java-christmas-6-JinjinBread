package christmas.validator;

import java.util.Arrays;

public class MenuValidator {

    private static final String EMPTY = "";
    private static final String DELIMITER = "-";
    private static final String INVALID_INPUT_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void validateContainsEmpty(String[] inputs) {
        if (Arrays.asList(inputs).contains(EMPTY))
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

    public static void validateSplitSize(String orderMenu) {
        String[] splitOrderMenu = orderMenu.split(DELIMITER);
        if (splitOrderMenu.length != 2)
            throw new IllegalArgumentException(INVALID_INPUT_MENU_ERROR_MESSAGE);
    }

}
