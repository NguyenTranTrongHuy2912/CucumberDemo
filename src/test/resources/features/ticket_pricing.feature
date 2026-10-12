Feature: Tinh gia ve ho boi Golden Splash

  Scenario Outline: Kiem tra gia ve theo ngay, trang thai khach, gio vao va do tuoi
    Given Khach den vao ngay "<dayType>", trang thai la "<status>"
    And Gio vao ho boi la "<entryHour>" va do tuoi la "<age>"
    When He thong thuc hien tinh gia ve
    Then Gia ve phai bang "<expectedPrice>"

    Examples:
      | dayType | status | entryHour | age   | expectedPrice |
      | Weekday | OT     | 10.00     | 10.00 | 5.00          |
      | Weekday | OT     | 20.00     | 10.00 | 6.00          |
      | Weekday | M      | 10.00     | 10.00 | 2.50          |
      | Weekday | M      | 20.00     | 10.00 | 3.00          |
      | Weekend | OT     | 10.00     | 10.00 | 7.50          |
      | Weekend | OT     | 20.00     | 10.00 | 9.00          |
      | Weekend | M      | 10.00     | 10.00 | 3.50          |
      | Weekend | M      | 20.00     | 10.00 | 4.00          |
      | Weekday | OT     | 15.00     | 30.00 | 10.00         |
      | Weekend | OT     | 21.00     | 30.00 | 18.00         |
      | Weekend | M      | 20.00     | 70.00 | 5.50          |