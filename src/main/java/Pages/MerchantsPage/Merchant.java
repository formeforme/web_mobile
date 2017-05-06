package Pages.MerchantsPage;


public class Merchant {
    private String ID;
    private String brandName;
    private String email;
    private int paymentCycle;
    private int BV;
    private String shopName;
    private String shopAddress;
    private String phoneNumber;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(int paymentCycle) {
        this.paymentCycle = paymentCycle;
    }

    public int getBV() {
        return BV;
    }

    public void setBV(int BV) {
        this.BV = BV;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
