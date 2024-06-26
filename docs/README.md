## 기능 목록 정리

```
고객의 방문 날짜와 주문 메뉴에 따른 혜택을 미리 보여주는 기능
```

- ✅ 고객의 방문 날짜를 입력받는다. int date
    - ✅ 1~31 사이의 숫자만 입력 가능하다. December 클래스에서 검증
      - ✅ 숫자인지 검증할 수 있다.
- ✅ 고객이 주문할 메뉴를 입력받는다. Order → Map<Menu, Integer>
    - ✅ (메뉴이름)-(메뉴개수),(메뉴이름)-(메뉴개수)···의 형식으로 입력받아야 한다.
    - ✅ 메뉴개수는 1개 이상이어야 한다.
    - ✅ 메뉴이름은 메뉴판에 있는 메뉴여야 한다.
      - ✅ 존재하는 메뉴인지 판단하는 기능 Menu#existMenu(String menuName)
    - ✅ 중복 메뉴는 입력할 수 없다.
    - ✅ 음료만 주문할 수 없다.
    - ✅ 메뉴는 한 번에 최대 20개까지 주문 가능하다.
- ✅ 고객의 할인 전 총주문 금액을 구할 수 있다. Order#calculateTotalOrderAmount
- ✅ 이벤트는 총주문 금액 10,000원 이상부터 적용된다. isOver10000
- ✅ 고객은 크리스마스 할인을 받을 수 있다. ChristmasDiscount
    - ✅ 1일 부터 1,000원으로 시작하여 25일까지 100원씩 증가한다.
    - ✅ 고객의 방문 날짜가 1일 ~ 25일 사이인지 알 수 있다. isChristmasPeriod
- ✅ 고객은 평일에(일요일~목요일) 디저트 메뉴를 개당 2,023원 할인 받을 수 있다. WeekdayDiscount
    - ✅ 고객의 방문 날짜가 평일인지 알 수 있다. isWeekday, int date
    - ✅ 고객이 주문한 디저트 메뉴의 개수를 알 수 있다. Order#countCategoryMenu(Category)
      - ✅ 고객이 주문한 메뉴가 디저트 메뉴인지 알 수 있다. Category#isCategoryMenu(Menu, Category)
- ✅ 고객은 주말에(금요일, 토요일) 메인 메뉴를 개당 2,023원 할인 받을 수 있다. WeekendDiscount
    - ✅ 고객의 방문 날짜가 주말인지 알 수 있다. isWeekend, int date
    - ✅ 고객이 주문한 메인 메뉴의 개수를 알 수 있다. Order#countCategoryMenu(Category)
      - ✅ 고객이 주문한 메뉴가 메인 메뉴인지 알 수 있다. Category#isCategoryMenu(Menu, Category)
- ✅ 이벤트 달력에 별이 있는 날이면 고객은 1,000원 할인 받을 수 있다. Calendar
    - ✅ 고객이 방문하는 날짜가 별이 있는 날인지 알 수 있다. isSpecialDay, int date
- ✅ 고객의 할인 전 총주문 금액이 12만 원 이상이면 샴페인 1개를 증정 받는다. isOver120000
    - ✅ 총주문 금액이 12만 원 미만이면 증정 메뉴 “없음”으로 출력한다.
- ✅ 고객의 총 혜택 금액을 구할 수 있다. Benefits#calculateTotalBenefitsAmount()
    - ✅ 총 혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격 Discounts#calculateTotalDiscountAmount() + GiveawayEvent#calculateGiveawayPrice()
    - ✅ 고객에게 적용된 이벤트 내역만 출력한다.
        - ✅ 각 할인마다 할인 금액이 0원인지 알 수 있다. (0원인 경우 이벤트가 적용되지 않은 것)
    - ✅ 적용된 이벤트가 하나도 없다면 혜택 내역 “없음”으로 출력한다.
        - ✅ 모든 할인 금액이 0원인지 알 수 있다.
- ✅ 고객의 총 혜택 금액이 5천 원 이상일 경우 ‘별’ 배지를 부여 받는다.
- ✅ 고객의 총 혜택 금액이 1만 원 이상일 경우 ‘트리’ 배지를 부여 받는다.
- ✅ 고객의 총 혜택 금액이 2만 원 이상일 경우 ‘산타’ 배지를 부여 받는다.
- ✅ 배지가 부여되지 않는 경우 “없음”을 출력한다.
- ✅ 고객의 할인 후 예상 결제 금액을 구할 수 있다. PlannerService
    - ✅ 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액