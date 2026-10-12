package iuh.fit;

public class TicketService {
    public double calculatePrice(String dayType, String status, double entryHour, double age) {
        boolean isWeekend = dayType.equalsIgnoreCase("Weekend");
        boolean isMember = status.equalsIgnoreCase("M");

        // Nhóm tuổi 0.0 - 16.00
        if (age >= 0.0 && age <= 16.00) {
            if (!isWeekend) { // Ngày thường
                if (!isMember) return (entryHour <= 19.00) ? 5.00 : 6.00;
                else return (entryHour <= 19.00) ? 2.50 : 3.00;
            } else { // Cuối tuần
                if (!isMember) return (entryHour <= 19.00) ? 7.50 : 9.00;
                else return (entryHour <= 19.00) ? 3.50 : 4.00;
            }
        }
        // Nhóm tuổi 16.01 - 60.00
        else if (age > 16.00 && age <= 60.00) {
            if (!isWeekend) {
                if (!isMember) return (entryHour <= 19.00) ? 10.00 : 12.00;
                else return (entryHour <= 19.00) ? 5.00 : 6.00;
            } else {
                if (!isMember) return (entryHour <= 19.00) ? 15.00 : 18.00;
                else return (entryHour <= 19.00) ? 7.00 : 8.00;
            }
        }
        // Nhóm tuổi 60.01 - 120.00
        else if (age > 60.00 && age <= 120.00) {
            if (!isWeekend) {
                if (!isMember) return 8.00;
                else return 4.00;
            } else {
                if (!isMember) return 12.00;
                else return 5.50;
            }
        }
        return -1; // Dữ liệu không hợp lệ
    }
}