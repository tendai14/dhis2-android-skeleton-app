package com.example.android.androidskeletonapp.ui.tracker_import_conflicts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.androidskeletonapp.R;
import com.example.android.androidskeletonapp.ui.base.SubListItemHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.hisp.dhis.android.core.imports.TrackerImportConflict;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.CONFLICT;
import static android.provider.Settings.NameValueTable.VALUE;

public class TrackerImportConflictsAdapter extends RecyclerView.Adapter<SubListItemHolder> {

    // TODO bind conflicts to sub_list_item.xml



    List<TrackerImportConflict> conflicts = new ArrayList<>();

    public void setConflicts(List<TrackerImportConflict> conflicts) {
        this.conflicts = conflicts;
    }

    @NonNull
    @Override
    public SubListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_list_item, parent, false);
        return new SubListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubListItemHolder holder, int position) {
        TrackerImportConflict trackerImportConflict = conflicts.get(position);
        holder.title.setText(trackerImportConflict.conflict());
        holder.rightText.setText(trackerImportConflict.value());
    }

    @Override
    public int getItemCount() {
        return conflicts.size();
    }
}