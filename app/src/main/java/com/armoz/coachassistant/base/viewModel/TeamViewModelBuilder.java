package com.armoz.coachassistant.base.viewModel;

public class TeamViewModelBuilder {
    private String name;
    private String category;
    private String club;

    public static TeamViewModelBuilder teamViewModel(){
        return new TeamViewModelBuilder();
    }

    public TeamViewModelBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamViewModelBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public TeamViewModelBuilder setClub(String club) {
        this.club = club;
        return this;
    }

    public TeamViewModel build() {
        return new TeamViewModel(name, category, club);
    }
}