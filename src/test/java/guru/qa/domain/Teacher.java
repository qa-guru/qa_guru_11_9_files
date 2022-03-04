package guru.qa.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teacher {
    public String name;
    public String surname;
    @SerializedName("favorite_music")
    public List<String> favoriteMusic;
    public Address address;

    @Override
    public String toString() {
        return "Имя: " + name;
    }
}
