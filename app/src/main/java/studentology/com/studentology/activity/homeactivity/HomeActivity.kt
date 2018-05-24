package studentology.com.studentology.activity.homeactivity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import studentology.com.studentology.R
import studentology.com.studentology.fragment.`fun`.FragmentFun
import studentology.com.studentology.fragment.education.FragmentEducation
import studentology.com.studentology.fragment.home.FragmentHome

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_home -> {
                selectedFragment = FragmentHome()
            }
            R.id.navigation_dashboard -> {
                selectedFragment = FragmentEducation()
            }
            R.id.navigation_notifications -> {
                selectedFragment = FragmentFun()
            }
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, selectedFragment)
        transaction.commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, FragmentHome())
        transaction.commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
