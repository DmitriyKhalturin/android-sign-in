package dmitriykhalturin.signin.repository

import io.reactivex.Single

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 04.09.19 1:55.
 */
interface WeatherRepository {
  fun getTemperatureInLondon(): Single<String>
}
