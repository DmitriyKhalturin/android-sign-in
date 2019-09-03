package dmitriykhalturin.signin.di

import dmitriykhalturin.signin.component.notification.Notification
import dmitriykhalturin.signin.repository.WeatherRepository
import dmitriykhalturin.signin.repository.WeatherRepositoryImpl
import dmitriykhalturin.signin.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 04.09.19 0:44.
 */
object KoinModule {
  val androidModule = module {
    factory { Notification(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl() }
    viewModel { SignInViewModel(get(), get()) }
  }
}
