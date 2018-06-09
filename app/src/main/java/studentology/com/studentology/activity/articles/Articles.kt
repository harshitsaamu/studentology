package studentology.com.studentology.activity.articles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_articles.*
import kotlinx.android.synthetic.main.content_articles.*
import studentology.com.studentology.R

class Articles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        setSupportActionBar(toolbar)
        if (intent.hasExtra("content")) {
            article_content.text = intent.extras.getString("content").toString()
        }
    }
}
