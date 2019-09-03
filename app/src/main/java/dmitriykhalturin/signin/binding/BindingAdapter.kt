package dmitriykhalturin.signin.binding

import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.github.florent37.viewtooltip.ViewTooltip
import com.google.android.material.textfield.TextInputLayout
import dmitriykhalturin.signin.R

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 03.09.19 21:50.
 */
object BindingAdapter {
  @BindingAdapter(value = ["rulesTooltip"])
  @JvmStatic
  fun bindRulesTooltip(textInputLayout: TextInputLayout, text: String) {
    val context = textInputLayout.context
    val textColor = ContextCompat.getColor(context, R.color.white)
    val backgroundColor = ContextCompat.getColor(context, R.color.greyish_brown)
    var tooltip: ViewTooltip?

    textInputLayout.setEndIconOnClickListener { _ ->
      tooltip = ViewTooltip
        .on(textInputLayout)
        .autoHide(true, 3000L)
        .clickToHide(true)
        .position(ViewTooltip.Position.BOTTOM)
        .text(text)
        .textColor(textColor)
        .color(backgroundColor)
        .onHide {
          tooltip = null
        }

      tooltip?.show()
    }
  }
}
