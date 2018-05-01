package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichObj = new JSONObject(json);
            JSONObject nameObj = sandwichObj.getJSONObject("name");
            JSONArray akaArray = nameObj.getJSONArray("alsoKnownAs");
            String [] aka = new String[akaArray.length()];
            for (int i = 0; i < akaArray.length(); i++){
                aka[i] = akaArray.getString(i);
            }
            JSONArray ingredientsArray = sandwichObj.getJSONArray("ingredients");
            String [] ingredients = new String[ingredientsArray.length()];
            for (int i = 0; i < ingredientsArray.length(); i++){
                ingredients[i] = ingredientsArray.getString(i);
            }
            sandwich.setMainName(nameObj.getString("mainName"));
            sandwich.setAlsoKnownAs(Arrays.asList(aka));
            sandwich.setPlaceOfOrigin(sandwichObj.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichObj.getString("description"));
            sandwich.setImage(sandwichObj.getString("image"));
            sandwich.setIngredients(Arrays.asList(ingredients));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
