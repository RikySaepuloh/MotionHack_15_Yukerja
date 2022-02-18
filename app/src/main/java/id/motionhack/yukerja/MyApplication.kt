@file:Suppress("unused")

package id.motionhack.yukerja

import android.app.Application
//import id.motionhack.yukerja..di.networkModule
//import id.motionhack.yukerja..di.repositoryModule
//import id.motionhack.yukerja..di.useCaseModule
import id.motionhack.yukerja.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
//                    networkModule,
////                    databaseModule,
//                    repositoryModule,
//                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}