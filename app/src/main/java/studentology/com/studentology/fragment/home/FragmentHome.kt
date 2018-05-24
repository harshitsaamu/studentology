package studentology.com.studentology.fragment.home

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import studentology.com.studentology.R

class FragmentHome:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_home)
    }
}