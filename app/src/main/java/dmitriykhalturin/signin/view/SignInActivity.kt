package dmitriykhalturin.signin.view

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import dmitriykhalturin.signin.R
import dmitriykhalturin.signin.databinding.ActivitySignInBinding
import dmitriykhalturin.signin.viewmodel.SignInViewModel

class SignInActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)

    val signInViewModel = ViewModelProviders
      .of(this)
      .get(SignInViewModel::class.java)

    binding.signInViewModel = signInViewModel

    supportActionBar?.apply {
      setDisplayHomeAsUpEnabled(true)
      setHomeAsUpIndicator(R.drawable.ic_back)
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.sign_in, menu)
    return true
  }
}
