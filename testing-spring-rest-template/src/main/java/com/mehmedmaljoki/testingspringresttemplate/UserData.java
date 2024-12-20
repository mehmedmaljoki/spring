package com.mehmedmaljoki.testingspringresttemplate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {

    private Long id;
    private String email;
    private String avatar;
    private String firstName;
    private String lastName;

    @JsonCreator
    public UserData(
            @JsonProperty("id") Long id,
            @JsonProperty("email") String email,
            @JsonProperty("avatar") String avatar,
            @JsonProperty("first_name") String firstName, 
            @JsonProperty("last_name") String lastName) {
        this.id = id;
        this.email = email;
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserData{"
                + "id="
                + id
                + ", email='"
                + email
                + '\''
                + ", avatar='"
                + avatar
                + '\''
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + '}';
    }
}
