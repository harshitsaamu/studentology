package studentology.com.studentology.fragment.education

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.LinearLayout
import com.google.firebase.database.FirebaseDatabase
import studentology.com.studentology.R
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_home.*
import studentology.com.studentology.fragment.home.PosterAdapter


class FragmentEducation : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_education, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        val articleRef = database.reference.child("education").child("article")

        articleRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                val educationalArticleArray: ArrayList<EducationalArticleItems> = ArrayList()
                for (articleSnapshot: DataSnapshot in dataSnapshot!!.children) {
                    val tags = ArrayList<String>()
                    for (tagsList: DataSnapshot in articleSnapshot.child("tags").children)
                        tags.add(tagsList.getValue(String::class.java)!!)
                    educationalArticleArray.add(EducationalArticleItems(articleSnapshot.child("image_url").getValue(String::class.java)!!
                            , articleSnapshot.child("title").getValue(String::class.java)!!
                            , articleSnapshot.child("author").getValue(String::class.java)!!,
                            articleSnapshot.child("time").getValue(String::class.java)!!,
                            tags))
                }
                setAdapter(educationalArticleArray)
            }

            override fun onCancelled(error: DatabaseError?) {

            }
        })

    }

    private fun setAdapter(articleArray: List<EducationalArticleItems>) {
        main_posters.layoutManager = LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false)
        main_posters.setHasFixedSize(false)
        main_posters.adapter = EducationalArticleAdapter(requireContext(), articleArray)
    }

    override fun onPause() {
        super.onPause()
        super.onDestroy()
    }

}
