package com.runcode.gadsleaderboard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.runcode.gadsleaderboard.R;
import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LearnersIQAdapter extends RecyclerView.Adapter<LearnersIQAdapter.LearnerAdapterViewHolder> {

    private List<IQLearner> items = new ArrayList<>();

    public LearnersIQAdapter() {
    }

    @Override
    public LearnerAdapterViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learner_item, parent, false);
        return new LearnerAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LearnerAdapterViewHolder holder, int position) {
        IQLearner item = items.get(position);
        //TODO Fill in your logic for binding the view.
        holder.name.setText(item.getName());
        String details = item.getScore() + " Score , " + item.getCountry();
        holder.details.setText(details);
        Picasso.get()
                .load(item.getBadgeUrl())
                .into(holder.badgeImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        holder.badgeImage.setImageResource(R.drawable.ic_error_24);
                    }
                });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public void setItems (List<IQLearner> items)
    {
        this.items = items ;
        notifyDataSetChanged();
    }

    public static class LearnerAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name  , details;
        ImageView badgeImage ;
        ProgressBar mProgressBar;
        public LearnerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.learnerName);
            details = itemView.findViewById(R.id.learnerScore_hours);
            badgeImage = itemView.findViewById(R.id.badge_image);
            mProgressBar = itemView.findViewById(R.id.bar);
        }
    }
}