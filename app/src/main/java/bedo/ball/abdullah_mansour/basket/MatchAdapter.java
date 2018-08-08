package bedo.ball.abdullah_mansour.basket;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullah_mansour.basket.R;

import bedo.ball.abdullah_mansour.basket.*;

import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {


    // Constant for date format
    private static final String DATE_FORMAT = "dd/MM/yyy";

    // Class variables for the List that holds task data and the Context
    private List<MatchesEntry> MmatchesEntries;
    private Context mContext;
    // Date formatter
    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());


    public MatchAdapter(Context context) {
        mContext = context;
    }

    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.history_layout, parent, false);

        return new MatchViewHolder(view);
    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position)
    {
        // Determine the values of the wanted data
        MatchesEntry matchesEntry = MmatchesEntries.get(position);

        String teamAname = matchesEntry.getTeamA();
        String teamBname = matchesEntry.getTeamB();
        String teamAresult = matchesEntry.getResultA();
        String teamBresult = matchesEntry.getResultB();

        String updatedAt = dateFormat.format(matchesEntry.getUpdatedAt());

        //Set values
        holder.teamAname.setText(teamAname);
        holder.teamBname.setText(teamBname);
        holder.teamAresult.setText(teamAresult);
        holder.teamBresult.setText(teamBresult);

        holder.matchDate.setText(updatedAt);

    }

    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (MmatchesEntries == null) {
            return 0;
        }
        return MmatchesEntries.size();
    }

    public List<MatchesEntry> getTasks() {
        return MmatchesEntries;
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setTasks(List<MatchesEntry> matchesEntries) {
        MmatchesEntries = matchesEntries;
        notifyDataSetChanged();
    }

    class MatchViewHolder extends RecyclerView.ViewHolder {

        // Class variables for the task description and priority TextViews
        TextView teamAname,teamAresult,teamBname,teamBresult,matchDate;


        /**
         * Constructor for the TaskViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        public MatchViewHolder (View itemView) {
            super(itemView);

            teamAname = (TextView) itemView.findViewById(R.id.teamAname);
            teamAresult = (TextView) itemView.findViewById(R.id.teamAresult);
            teamBname = (TextView) itemView.findViewById(R.id.teamBname);
            teamBresult = (TextView) itemView.findViewById(R.id.teamBresult);
            matchDate = (TextView) itemView.findViewById(R.id.match_date);
        }
    }
}
