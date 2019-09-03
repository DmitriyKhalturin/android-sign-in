package dmitriykhalturin.signin.repository

import io.reactivex.Single
import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 04.09.19 0:50.
 */
class WeatherRepositoryImpl : WeatherRepository {
  override fun getTemperatureInLondon() = Single.create<String> { emitter ->
    Timer().schedule(1500L) {
      emitter.onSuccess("0 °C in London")
    }
  }
}
