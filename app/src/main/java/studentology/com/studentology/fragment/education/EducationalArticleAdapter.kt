package studentology.com.studentology.fragment.education

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_education_news.view.*
import studentology.com.studentology.R

class EducationalArticleAdapter(private val context: Context, private val articleItem: List<EducationalArticleItems>) : RecyclerView.Adapter<EducationalArticleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationalArticleAdapter.ViewHolder {
        val articleView = LayoutInflater.from(context).inflate(R.layout.layout_education_news, parent, false)
        return ViewHolder(articleView)
    }

    override fun getItemCount(): Int {
        return articleItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(articleItem[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(data: EducationalArticleItems) {
            if (data.imageUrl != "null") {
                itemView.education_article_image.visibility = View.VISIBLE
                Glide.with(context).load(data.imageUrl).into(itemView.education_article_image)
            } else {
                itemView.education_article_image.visibility = View.GONE
            }
            itemView.edu_article_title.text = data.title
            itemView.edu_article_author.text = data.author.plus(" " + data.time)
        }
    }
}
