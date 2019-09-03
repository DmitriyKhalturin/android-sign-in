package dmitriykhalturin.signin.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Sign In on 04.09.19 1:57.
 */
open class BaseViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()

  var disposable: Disposable
    get() = throw IllegalAccessException()
    set(value) { compositeDisposable.add(value) }

  override fun onCleared() {
    compositeDisposable.dispose()

    super.onCleared()
  }
}
