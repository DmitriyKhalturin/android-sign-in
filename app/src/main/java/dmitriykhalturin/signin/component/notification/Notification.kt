package dmitriykhalturin.signin.component.notification

import android.content.Context
import android.widget.Toast

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 04.09.19 0:59.
 */
class Notification(private val context: Context) {

  fun toast(resId: Int) {
    Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
  }
}
