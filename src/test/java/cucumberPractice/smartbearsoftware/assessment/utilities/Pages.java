package cucumberPractice.smartbearsoftware.assessment.utilities;

import cucumberPractice.smartbearsoftware.assessment.pages.LoginPage;
import cucumberPractice.smartbearsoftware.assessment.pages.OrderPage;
import cucumberPractice.smartbearsoftware.assessment.pages.WebOrdersPage;

public class Pages {

    private WebOrdersPage webOrdersPage;
    private LoginPage loginPage;

    private OrderPage orderPage;

    public Pages() {
        this.webOrdersPage = new WebOrdersPage();
        this.loginPage = new  LoginPage();
        this.orderPage = new OrderPage();
    }

    public WebOrdersPage getWebOrdersPage() {
        return webOrdersPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public OrderPage getOrderPage(){
        return orderPage;
    }
}