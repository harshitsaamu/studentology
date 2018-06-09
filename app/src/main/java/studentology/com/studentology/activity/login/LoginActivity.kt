package studentology.com.studentology.activity.login

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import studentology.com.studentology.R

class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login)
        initialize()
    }

    private fun initialize() {

    }
}