package iuh.fit.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import iuh.fit.TicketService;
import org.junit.Assert;

public class TicketSteps {

    private String dayType;
    private String status;
    private double entryHour;
    private double age;
    private double actualPrice;

    private final TicketService service = new TicketService();

    // Dong 4: Given Khach den vao ngay "<dayType>", trang thai la "<status>"
    @Given("Khach den vao ngay {string}, trang thai la {string}")
    public void thiet_lap_ngay_va_trang_thai(String dayType, String status) {
        this.dayType = dayType;
        this.status = status;
    }

    // Dong 5: And Gio vao ho boi la "<entryHour>" va do tuoi la "<age>"
    @And("Gio vao ho boi la {string} va do tuoi la {string}")
    public void thiet_lap_gio_va_tuoi(String entryHour, String age) {
        this.entryHour = Double.parseDouble(entryHour);
        this.age = Double.parseDouble(age);
    }

    // Dong 6: When He thong thuc hien tinh gia ve
    @When("He thong thuc hien tinh gia ve")
    public void he_thong_tinh_gia_ve() {
        this.actualPrice = service.calculatePrice(dayType, status, entryHour, age);
    }

    // Dong 7: Then Gia ve phai bang "<expectedPrice>"
    @Then("Gia ve phai bang {string}")
    public void kiem_tra_gia_ve(String expectedPrice) {
        Assert.assertEquals(Double.parseDouble(expectedPrice), actualPrice, 0.001);
    }
}