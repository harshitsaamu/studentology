package studentology.com.studentology.fragment.profile

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import studentology.com.studentology.R

class ProfileActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_profile)
    }
}