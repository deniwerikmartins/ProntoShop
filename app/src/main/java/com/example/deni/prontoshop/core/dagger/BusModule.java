package com.example.deni.prontoshop.core.dagger;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deni on 27/03/2017.
 */

@Module
public class BusModule {

    @Provides
    @Singleton
    public Bus provideBus(){
        return new Bus();
    }
}
