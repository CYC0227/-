package gachon.mpclass.mp_team_newnew.form;

public class TodaySaleForm {
    private String info;
    private String address;
    private String address_around;

    @Override
    public String toString() {
        return "TodaySaleForm{" +
                "info='" + info + '\'' +
                ", address='" + address + '\'' +
                ", address_around='" + address_around + '\'' +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_around() {
        return address_around;
    }

    public void setAddress_around(String address_around) {
        this.address_around = address_around;
    }
}
