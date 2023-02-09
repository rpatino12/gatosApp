package org.example;

import java.io.IOException;
import okhttp3.*;
import com.google.gson.Gson;

import java.awt.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CatService {
    public static void showCats() throws IOException {

        // First we get the data from the API, the following code was extracted from Postman (code snippet)
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        // Using the GET method, we request create the request
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
        // Now we execute the request and store the response in the Response object
        // And we have to the method throw an IOException, because this method is connecting with things external to the app
        Response response = client.newCall(request).execute();

        // Now we store the API response with the String type
        String jsonResponse = response.body().string();
        // And we have to format the string, so we can erase the square brackets that come with the response by default
        jsonResponse = jsonResponse.substring(1, jsonResponse.length() - 1);


        // Finally we create a Gson object, to convert the API response to a Cat object
        Gson gson = new Gson();
        // Here we parse the response to the Cat type, so this Cat object has the attributes "id", "url", "image"
        Cat cat = gson.fromJson(jsonResponse, Cat.class);

        // Now we need to show the cat image in the UI
        Image image = null;
        try {
            // We get the url of the image from the getUrl method of the cat object
            URL url = new URL(cat.getUrl());
            // Now we read the image url to load the image in the screen
            image = ImageIO.read(url);

            // Because the swing.JOptionPane class receives an image icon object we cast the image to an image icon object
            ImageIcon catIcon = new ImageIcon(image);

            // The extra step is resize the image in the case that the result image is too large
            if (catIcon.getIconWidth() > 800){
                // With the Image class methods we can scale the image, so we cast again the catIcon
                Image catImage = catIcon.getImage();
                Image resize = catImage.getScaledInstance(800, 600, Image.SCALE_SMOOTH);

                // Finally we have the catIcon resized, if it was needed
                catIcon = new ImageIcon(resize);
            }

            // Finally we create a menu to show the cat images
            String menuHeader = " Select an option: \n"
                    + "1. Show another image \n"
                    + "2. Mark as favorite \n"
                    + "3. Go back";

            String[] buttons = {"Show next image", "Favorite", "Back"};
            String idGato = cat.getId();
            // Show the UI
            String option = (String) JOptionPane.showInputDialog(null, menuHeader, idGato, JOptionPane.INFORMATION_MESSAGE, catIcon, buttons, buttons[0]);

            // Now we validate the user selection
            switch (option){
                case "Show next image":
                    showCats();
                    break;
                case "Favorite":
                    markAsFavorite(cat);
                    break;
                default:
                    break;
            }
        }
        // We have to add an IOException
        catch (IOException e){
            System.err.println(e);
        }
    }

    public static void markAsFavorite(Cat cat){
    }
}
