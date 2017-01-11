package com.armoz.coachassistant.chooseTeam.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.armoz.coachassistant.R;
import com.armoz.coachassistant.base.viewModel.TeamViewModel;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<TeamViewModel> teams;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View teamCardView;
        public TextView teamNameView;

        public ViewHolder(View teamCardView, TextView teamNameView) {
            super(teamCardView);
            this.teamCardView = teamCardView;
            this.teamNameView = teamNameView;
        }
    }

    public TeamAdapter(List<TeamViewModel> teams) {
        this.teams = teams;
    }

    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View teamCardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team_card, parent, false);

        final TextView teamNameView = (TextView) teamCardView.findViewById(R.id.teamName);

        final ViewHolder vh = new ViewHolder(teamCardView, teamNameView);

        teamCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                teamNameView.setText("clicked");
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.teamNameView.setText(teams.get(position).getClub());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}