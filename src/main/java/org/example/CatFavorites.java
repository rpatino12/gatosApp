package org.example;
// We have to create this class and ImageResponse class, so we can parse the response of GET favorites from the cat API
public class CatFavorites {
    // The attributes have the same name as the variables in the response so gson can parse the response from JSON to Java attributes
    private String id;
    private String image_id;
    private ImageResponse image;

    private String apikey = System.getenv("CATS_API_KEY");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public ImageResponse getImage() {
        return image;
    }

    public void setImage(ImageResponse image) {
        this.image = image;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
