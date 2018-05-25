package studentology.com.studentology.fragment.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_banner.view.*
import kotlinx.android.synthetic.main.layout_your_digest.view.*
import studentology.com.studentology.R

class DigestAdapter (val context: Context, val imageArray:List<String>) : RecyclerView.Adapter<DigestAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigestAdapter.ViewHolder {
        val DigestView = LayoutInflater.from(context).inflate(R.layout.layout_your_digest, parent, false)
        return ViewHolder(DigestView)
    }

    override fun getItemCount(): Int {
        return imageArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(imageArray[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(title: String) {
            itemView.head_line.text=title
        }
    }

}
