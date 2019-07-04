package com.example.android.androidskeletonapp.ui.d2_errors;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.example.android.androidskeletonapp.R;
import com.example.android.androidskeletonapp.data.Sdk;
import com.example.android.androidskeletonapp.ui.base.ListActivity;
import com.example.android.androidskeletonapp.ui.programs.ProgramsAdapter;

import org.hisp.dhis.android.core.arch.helpers.UidsHelper;
import org.hisp.dhis.android.core.arch.repositories.scope.RepositoryScope;
import org.hisp.dhis.android.core.maintenance.D2Error;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class D2ErrorActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp(R.layout.activity_d2_errors, R.id.d2ErrorsToolbar, R.id.d2ErrorsRecyclerView);
        // TODO List D2 errors
       observeErrors();

    }

    private void observeErrors() {
        D2ErrorAdapter adapter = new D2ErrorAdapter();
        recyclerView.setAdapter(adapter);

        LiveData<PagedList<D2Error>> errorPagedListLiveData =
                Sdk.d2().maintenanceModule().d2Errors
                .getPaged(15);

        errorPagedListLiveData.observe(this,pagedList ->{
            adapter.submitList(pagedList);
            findViewById(R.id.d2ErrorsNotificator).setVisibility(pagedList.isEmpty() ? View.GONE : View.VISIBLE);
        });
    }
}
