package dmitriykhalturin.signin.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dmitriykhalturin.signin.R
import dmitriykhalturin.signin.databinding.ActivitySignInBinding
import dmitriykhalturin.signin.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity : AppCompatActivity() {

  private val signInViewModel: SignInViewModel by viewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)

    binding.signInViewModel = signInViewModel

    supportActionBar?.apply {
      setDisplayHomeAsUpEnabled(true)
      setHomeAsUpIndicator(R.drawable.ic_back)
    }

    signInViewModel.rootView = findViewById(android.R.id.content)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.sign_in, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem?) = when(item?.itemId) {
    android.R.id.home -> {
      finish()
      true
    }
    else -> super.onOptionsItemSelected(item)
  }
}
