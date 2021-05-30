package gachon.mpclass.mp_team_newnew;

public class MyrecipeItem {
    private int profile; // 대문 사진
    private String title; // 요리 제목
    private String description; // 요리순서
    private String information; // 몇인분인지
    private String ingredients_name; // 재료 이름
    private String ingredients_quantity; // 재료 양
    private String anniversary; // 음식에 어룰리는 상황
    private String country; // 음식의 국가

    public int getProfile() {
        return profile;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInformation() {
        return information;
    }

    public String getIngredients_name() {
        return ingredients_name;
    }

    public String getIngredients_quantity() {
        return ingredients_quantity;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public String getCountry() {
        return country;
    }

    public MyrecipeItem(int profile, String title, String description, String information, String ingredients_name, String ingredients_quantity, String anniversary, String country) {
        this.profile = profile;
        this.title = title;
        this.description = description;
        this.information = information;
        this.ingredients_name = ingredients_name;
        this.ingredients_quantity = ingredients_quantity;
        this.anniversary = anniversary;
        this.country = country;
    }

}
