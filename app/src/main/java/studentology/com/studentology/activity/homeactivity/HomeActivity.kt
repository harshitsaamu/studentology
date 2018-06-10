package studentology.com.studentology.activity.homeactivity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import studentology.com.studentology.R
import studentology.com.studentology.activity.notifications.NotificationActivity
import studentology.com.studentology.fragment.`fun`.FragmentFun
import studentology.com.studentology.fragment.education.FragmentEducation
import studentology.com.studentology.fragment.home.FragmentHome
import studentology.com.studentology.fragment.profile.FragmentProfile

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_home -> {
                selectedFragment = FragmentHome()
            }
            R.id.navigation_education -> {
                selectedFragment = FragmentEducation()
            }
            R.id.navigation_fun -> {
                selectedFragment = FragmentFun()
            }
            R.id.navigation_profile -> {
                selectedFragment = FragmentProfile()
                val i = Intent(this, NotificationActivity::class.java)
                startActivity(i)
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
