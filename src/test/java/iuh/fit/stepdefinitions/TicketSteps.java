package iuh.fit.stepdefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import iuh.fit.TicketService;

public class TicketSteps {
    private final TicketService service = new TicketService();

    private String day;
    private String status;
    private double entryHour;
    private double age;
    private boolean inputInvalid = false; // true nếu giờ vào/tuổi không phải số
    private double actualPrice;

    @Given("Khach den vao ngay {string}, trang thai la {string}")
    public void khachDenVao(String day, String status) {
        this.day = day;
        this.status = status;
    }

    @Given("Gio vao ho boi la {string} va do tuoi la {string}")
    public void gioVaoVaDoTuoi(String hourText, String ageText) {
        try {
            this.entryHour = Double.parseDouble(hourText.trim());
            this.age = Double.parseDouble(ageText.trim());
        } catch (NumberFormatException e) {
            this.inputInvalid = true; // "Ba giờ", "Ba mươi", ô trống...
        }
    }

    @When("He thong thuc hien tinh gia ve")
    public void tinhGiaVe() {
        actualPrice = inputInvalid ? -1 : service.calculatePrice(day, status, entryHour, age);
    }

    @Then("Gia ve phai bang {string}")
    public void kiemTraGiaVe(String expected) {
        assertEquals(Double.parseDouble(expected), actualPrice, 0.001);
    }
}