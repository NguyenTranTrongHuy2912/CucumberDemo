Feature: Tinh gia ve ho boi Golden Splash

  Scenario Outline: TC<no> - Kiem tra gia ve theo ngay, trang thai, gio vao va do tuoi
    Given Khach den vao ngay "<day>", trang thai la "<status>"
    And Gio vao ho boi la "<entryHour>" va do tuoi la "<age>"
    When He thong thuc hien tinh gia ve
    Then Gia ve phai bang "<expectedPrice>"

    Examples: For Valid Partition (Input)
      | no | day | status | entryHour | age   | expectedPrice |
      | 1  | Mon | OT     | 7.00      | 15.00 | 5.00          |
      | 2  | Sat | M      | 20.00     | 19.00 | 8.00          |
      | 3  | Sat | M      | 20.00     | 70.00 | 5.50          |

    Examples: For Valid Partition (Output)
      | no | day | status | entryHour | age   | expectedPrice |
      | 4  | Mon | OT     | 20.00     | 15.00 | 6.00          |
      | 5  | Mon | M      | 7.00      | 15.00 | 2.50          |
      | 6  | Mon | M      | 20.00     | 15.00 | 3.00          |
      | 7  | Sat | OT     | 7.00      | 15.00 | 7.50          |
      | 8  | Sat | OT     | 20.00     | 15.00 | 9.00          |
      | 9  | Sat | M      | 7.00      | 15.00 | 3.50          |
      | 10 | Sat | M      | 20.00     | 15.00 | 4.00          |
      | 11 | Mon | OT     | 7.00      | 19.00 | 10.00         |
      | 12 | Mon | OT     | 20.00     | 19.00 | 12.00         |
      | 13 | Mon | M      | 7.00      | 19.00 | 5.00          |
      | 14 | Mon | M      | 20.00     | 19.00 | 6.00          |
      | 15 | Sat | OT     | 7.00      | 19.00 | 15.00         |
      | 16 | Sat | OT     | 20.00     | 19.00 | 18.00         |
      | 17 | Sat | M      | 7.00      | 19.00 | 7.00          |
      | 18 | Mon | OT     | 20.00     | 70.00 | 8.00          |
      | 19 | Mon | M      | 20.00     | 70.00 | 4.00          |
      | 20 | Sat | OT     | 20.00     | 70.00 | 12.00         |

    Examples: For Invalid Partition (Input)
      | no | day     | status | entryHour | age      | expectedPrice |
      | 21 | January | OT     | 7.00      | 15.00    | -1            |
      | 22 |         | OT     | 7.00      | 15.00    | -1            |
      | 23 | Mon     | VIP    | 7.00      | 15.00    | -1            |
      | 24 | Mon     |        | 7.00      | 15.00    | -1            |
      | 25 | Mon     | OT     | 3.00      | 15.00    | -1            |
      | 26 | Mon     | OT     | 27.00     | 15.00    | -1            |
      | 27 | Mon     | OT     | Ba giờ    | 15.00    | -1            |
      | 28 | Mon     | OT     |           | 15.00    | -1            |
      | 29 | Mon     | OT     | 7.00      | -10.00   | -1            |
      | 30 | Mon     | OT     | 7.00      | 130.00   | -1            |
      | 31 | Mon     | OT     | 7.00      | Ba mươi  | -1            |
      | 32 | Mon     | OT     | 7.00      |          | -1            |

    Examples: For Valid Boundary
      | no | day | status | entryHour | age    | expectedPrice |
      | 33 | Mon | OT     | 6.00      | 0.00   | 5.00          |
      | 34 | Mon | OT     | 24.00     | 120.00 | 8.00          |

    Examples: For Invalid Boundary (Input)
      | no | day | status | entryHour | age    | expectedPrice |
      | 35 | Mon | OT     | 5.59      | 15.00  | -1            |
      | 36 | Mon | OT     | 24.01     | 15.00  | -1            |
      | 37 | Mon | OT     | 7.00      | -0.01  | -1            |
      | 38 | Mon | OT     | 7.00      | 120.01 | -1            |