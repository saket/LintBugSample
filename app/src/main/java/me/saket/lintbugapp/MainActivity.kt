package me.saket.lintbugapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.saket.module.ClassWithLintErrors

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(TextView(this).apply {
      text = ClassWithLintErrors.text().joinToString()
    })
  }
}