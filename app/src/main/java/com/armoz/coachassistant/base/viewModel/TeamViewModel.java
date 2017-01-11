package com.armoz.coachassistant.base.viewModel;

public class TeamViewModel {

    private String name;
    private String category;
    private String club;

    public TeamViewModel(String name, String category, String club) {
        this.name = name;
        this.category = category;
        this.club = club;
    }

    public String getClub() {
        return club;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
