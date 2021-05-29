package gachon.mpclass.mp_team_newnew.form;


public class PostingForm {

    private int img;
    private String imgURL;
    private String title;
    private String description;
    private String information;
    private String ingredients_name;
    private String ingredients_quantity;
    private String anniversary;
    private String country;
    private String videoURL;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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

    @Override
    public String toString() {
        return "PostingForm{" +
                "imgURL='" + imgURL + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", information='" + information + '\'' +
                ", ingredients_name='" + ingredients_name + '\'' +
                ", ingredients_quantity='" + ingredients_quantity + '\'' +
                ", anniversary='" + anniversary + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
