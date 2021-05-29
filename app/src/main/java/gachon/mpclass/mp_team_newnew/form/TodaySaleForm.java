package gachon.mpclass.mp_team_newnew.form;

public class TodaySaleForm {
    private String info;
    private String address;

    @Override
    public String toString() {
        return "TodaySaleForm{" +
                "information='" + info + '\'' +
                ", address='" + address + '\'' +
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
}
