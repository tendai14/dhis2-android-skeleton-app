package com.example.android.androidskeletonapp.data;

import android.content.Context;

import org.hisp.dhis.android.core.D2;
import org.hisp.dhis.android.core.d2manager.D2Configuration;
import org.hisp.dhis.android.core.d2manager.D2Manager;

import java.util.Collections;

import io.reactivex.Single;

public class Sdk {

    public static D2Configuration getD2Configuration(Context context) {
        // TODO Add configuration


        D2Configuration d2Configuration = D2Configuration.builder()
                .appName("tendai14").appVersion("1.0.0")
                .context(context)
                .readTimeoutInSeconds(30)
                .connectTimeoutInSeconds(30)
                .writeTimeoutInSeconds(30)
                .build();

        return d2Configuration;


    }
}