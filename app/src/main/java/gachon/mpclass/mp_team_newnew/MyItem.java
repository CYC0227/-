package gachon.mpclass.mp_team_newnew;

public class MyItem {
    String title;
      String imgURL;
      String description;
      String information;
      String ingredients_name;
      String ingredients_quantity;
      String anniversary;
      String country;
      String videoURL;

    public MyItem(String title, String imgURL, String description, String ingredients_name, String ingredients_quantity, String anniversary, String country, String videoURL) {
        this.title = title;
        this.imgURL = imgURL;
        this.description = description;
        this.ingredients_name = ingredients_name;
        this.ingredients_quantity = ingredients_quantity;
        this.anniversary = anniversary;
        this.country = country;
        this.videoURL = videoURL;

    }

    public MyItem() {}

    public String getId() {
        return title;
    }
    public void setId(String title) {
        this.title = title;
    }

    public String getImgURL() {
        return imgURL;
    }
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients_name() {
        return ingredients_name;
    }
    public void setIngredients_name(String ingredients_name) {
        this.ingredients_name = ingredients_name;
    }

    public String getIngredients_quantity() {
        return ingredients_quantity;
    }
    public void setIngredients_quantity(String ingredients_quantity) {
        this.ingredients_quantity = ingredients_quantity;
    }

    public String getAnniversary() {
        return anniversary;
    }
    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getVideoURL() {
        return videoURL;
    }
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

}