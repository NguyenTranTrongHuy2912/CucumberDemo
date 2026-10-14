package iuh.fit;

import java.util.List;

public class TicketService {

    private static final List<String> WEEKDAYS = List.of(
            "mon", "monday", "tue", "tuesday", "wed", "wednesday",
            "thu", "thur", "thurs", "thursday", "fri", "friday");
    private static final List<String> WEEKENDS = List.of(
            "sat", "saturday", "sun", "sunday");

    public double calculatePrice(String day, String status, double entryHour, double age) {
        String d = day.trim().toLowerCase();
        String s = status.trim();

        boolean isWeekend = WEEKENDS.contains(d);
        boolean isWeekday = WEEKDAYS.contains(d);
        boolean isMember = s.equalsIgnoreCase("M");
        boolean isOneTime = s.equalsIgnoreCase("OT");

        // Cac truong hop khong hop le
        if (!isWeekend && !isWeekday) return -1;                // ngay sai
        if (!isMember && !isOneTime) return -1;                 // trang thai sai
        if (entryHour < 6.00 || entryHour > 24.00) return -1;   // gio vao sai
        if (age < 0 || age > 120) return -1;                    // tuoi sai

        // Nhóm tuổi 0.0 - 16.00
        if (age <= 16.00) {
            if (!isWeekend) { // Ngày thường
                if (!isMember) return (entryHour <= 19.00) ? 5.00 : 6.00;
                else return (entryHour <= 19.00) ? 2.50 : 3.00;
            } else { // Cuối tuần
                if (!isMember) return (entryHour <= 19.00) ? 7.50 : 9.00;
                else return (entryHour <= 19.00) ? 3.50 : 4.00;
            }
        }
        // Nhóm tuổi 16.01 - 60.00
        else if (age <= 60.00) {
            if (!isWeekend) {
                if (!isMember) return (entryHour <= 19.00) ? 10.00 : 12.00;
                else return (entryHour <= 19.00) ? 5.00 : 6.00;
            } else {
                if (!isMember) return (entryHour <= 19.00) ? 15.00 : 18.00;
                else return (entryHour <= 19.00) ? 7.00 : 8.00;
            }
        }
        // Nhóm tuổi 60.01 - 120.00
        else {
            if (!isWeekend) {
                return isMember ? 4.00 : 8.00;
            } else {
                return isMember ? 5.50 : 12.00;
            }
        }
    }
}