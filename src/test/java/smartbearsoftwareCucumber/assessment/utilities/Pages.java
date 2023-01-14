package smartbearsoftwareCucumber.assessment.utilities;


import smartbearsoftwareCucumber.assessment.pages.LoginPage;
import smartbearsoftwareCucumber.assessment.pages.OrderPage;
import smartbearsoftwareCucumber.assessment.pages.WebOrdersPage;

public class Pages {
    private WebOrdersPage webOrdersPage;
    private LoginPage loginPage;
    private OrderPage orderpage;

    public Pages() {
        this.loginPage = new LoginPage();
        this.webOrdersPage = new WebOrdersPage();
        this.orderpage = new OrderPage();
    }

    public WebOrdersPage webOrdersPage() {
        return webOrdersPage;
    }

    public LoginPage loginPage() {
        return loginPage;
    }
    public OrderPage orderPage() {
        return orderpage;
    }


}
