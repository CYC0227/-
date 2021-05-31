package gachon.mpclass.mp_team_newnew;

public class MyItem_Sale {
    String info;
    String address;

    public MyItem_Sale(String info, String address){
        this.info = info;
        this.address = address;
    }

    public MyItem_Sale() {}

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}

