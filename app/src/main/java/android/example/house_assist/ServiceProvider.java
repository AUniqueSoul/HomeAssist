package android.example.house_assist;

public class ServiceProvider {

    String address1, address2, dp, locality, name, pincode, price, service_type, state, server_provider_uid, customer_uid;

    public ServiceProvider(){
    }

    public ServiceProvider(String address1, String address2, String dp, String locality, String name, String pincode, String price, String service_type, String state, String server_provider_uid, String customer_uid) {
        this.address1 = address1;
        this.address2 = address2;
        this.dp = dp;
        this.locality = locality;
        this.name = name;
        this.pincode = pincode;
        this.price = price;
        this.service_type = service_type;
        this.state = state;
        this.server_provider_uid = server_provider_uid;
        this.customer_uid = customer_uid;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getServer_provider_uid() {
        return server_provider_uid;
    }

    public void setServer_provider_uid(String server_provider_uid) {
        this.server_provider_uid = server_provider_uid;
    }

    public String getCustomer_uid() {
        return customer_uid;
    }

    public void setCustomer_uid(String customer_uid) {
        this.customer_uid = customer_uid;
    }
}
