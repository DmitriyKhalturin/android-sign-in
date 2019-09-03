package dmitriykhalturin.signin.component

import android.app.Application
import dmitriykhalturin.signin.di.KoinModule.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 02.09.19 21:01.
 */
class SignInApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@SignInApplication)
      modules(androidModule)
    }
  }
}
