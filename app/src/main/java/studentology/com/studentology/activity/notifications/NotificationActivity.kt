package studentology.com.studentology.activity.notifications

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_notification.*
import studentology.com.studentology.R

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        initialize()
    }

    private fun initialize() {
        val database = FirebaseDatabase.getInstance()
        val posterRef = database.reference.child("notifications")

        posterRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val notificationArray: ArrayList<NotificationItems> = ArrayList()
                for (notificationSnapshot: DataSnapshot in dataSnapshot.children) {
                    notificationArray.add(NotificationItems(notificationSnapshot.child("title").getValue(String::class.java)!!,
                            notificationSnapshot.child("description").getValue(String::class.java)!!,
                            notificationSnapshot.child("bookmarked").getValue(String::class.java)!!))
                }
                setAdapter(notificationArray)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@NotificationActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setAdapter(notificationItems: ArrayList<NotificationItems>) {
        notificationsList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        notificationsList.setHasFixedSize(false)
        notificationsList.adapter = NotificationAdapter(this, notificationItems)
    }
}
