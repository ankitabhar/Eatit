package tannu.ankita.eatit.Model;

public class Food {
    public String description,menuid,price,name,image;

    public Food() {
    }

    public Food(String description, String menuid, String price, String name, String image) {
        this.description = description;
        this.menuid = menuid;
        this.price = price;
        this.name = name;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

}
