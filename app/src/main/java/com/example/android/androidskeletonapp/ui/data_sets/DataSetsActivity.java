package com.example.android.androidskeletonapp.ui.data_sets;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.example.android.androidskeletonapp.R;
import com.example.android.androidskeletonapp.data.Sdk;
import com.example.android.androidskeletonapp.ui.base.ListActivity;
import com.example.android.androidskeletonapp.ui.d2_errors.D2ErrorAdapter;

import org.hisp.dhis.android.core.dataset.DataSet;
import org.hisp.dhis.android.core.maintenance.D2Error;

public class DataSetsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp(R.layout.activity_data_sets, R.id.dataSetsToolbar, R.id.dataSetsRecyclerView);
        // TODO List DataSets

        observeDataSets();

    }

    private void observeDataSets(){

        DataSetsAdapter adapter = new DataSetsAdapter();
        recyclerView.setAdapter(adapter);

        LiveData<PagedList<DataSet>> liveData = Sdk.d2().dataSetModule().dataSets
                .getPaged(15);

        liveData.observe(this, dataSets -> {
            adapter.submitList(dataSets);
            findViewById(R.id.dataSetsNotificator).setVisibility(
                    dataSets.isEmpty() ? View.VISIBLE : View.GONE);
        });
    }
}
