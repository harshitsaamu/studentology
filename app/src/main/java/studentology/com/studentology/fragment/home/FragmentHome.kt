package studentology.com.studentology.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_home.*
import studentology.com.studentology.R
import studentology.com.studentology.activity.homeactivity.HomeActivity


class FragmentHome : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val posterRef = database.reference.child("banners")
        val digestRef = database.reference.child("digest")

        posterRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val imageArray: ArrayList<String> = ArrayList()
                var i = 1
                for (imageSnapshot: DataSnapshot in dataSnapshot.children) {
                    imageArray.add(imageSnapshot.getValue(String::class.java)!!)
                    i++
                }
                setAdapter(imageArray)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        digestRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                val imageArray: ArrayList<String> = ArrayList()
                for (imageSnapshot: DataSnapshot in dataSnapshot!!.children) {
                    imageArray.add(imageSnapshot.child("title").getValue(String::class.java)!!)
                }
                setDigestAdapter(imageArray)
            }

            override fun onCancelled(error: DatabaseError?) {

            }
        })

    }

    private fun setDigestAdapter(dataArray: ArrayList<String>) {
        your_digest.layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        your_digest.setHasFixedSize(false)
        your_digest.adapter = DigestAdapter(requireContext(), dataArray)
    }

    private fun setAdapter(imageArray: List<String>) {
        main_posters.layoutManager = LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false)
        main_posters.setHasFixedSize(false)
        main_posters.adapter = PosterAdapter(requireContext(), imageArray)
    }
}