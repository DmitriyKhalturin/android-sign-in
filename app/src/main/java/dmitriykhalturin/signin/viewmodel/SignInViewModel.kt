package dmitriykhalturin.signin.viewmodel

import android.util.Patterns
import android.view.View
import androidx.databinding.ObservableField
import com.google.android.material.snackbar.Snackbar
import dmitriykhalturin.signin.R
import dmitriykhalturin.signin.component.notification.Notification
import dmitriykhalturin.signin.repository.WeatherRepository
import java.util.regex.Pattern

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 02.09.19 21:04.
 */
class SignInViewModel(
  private val notification: Notification,
  private val repository: WeatherRepository
) : BaseViewModel() {

  companion object {
    private val PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=\\S+\$).{6,}$")
  }

  var rootView: View? = null

  val email = ObservableField<String>()
  val password = ObservableField<String>()
  val isLoading = ObservableField<Boolean>()

  fun signIn() {
    if (validateFields()) {
      isLoading.set(true)

      disposable = repository.getTemperatureInLondon().subscribe { message ->
        isLoading.set(false)

        rootView?.let {
          Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
        }
      }
    }
  }

  private fun validateFields() = when{
    invalidEmail(email.get()) -> {
      notification.toast(R.string.attention__email)
      false
    }
    invalidPassword(password.get()) -> {
      notification.toast(R.string.attention__password)
      false
    }
    else -> true
  }

  private fun invalidEmail(email: String?) =
    !(email is String && Patterns.EMAIL_ADDRESS.matcher(email).matches())

  private fun invalidPassword(password: String?) =  if (password is String) {
    !PASSWORD_PATTERN.matcher(password).matches()
  } else true
}
