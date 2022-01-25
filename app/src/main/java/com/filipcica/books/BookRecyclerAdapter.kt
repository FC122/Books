package com.filipcica.books

import android.accessibilityservice.GestureDescription
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class BookRecyclerAdapter(private val items:List<Book>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.book_view,
                parent,
                false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BookViewHolder->{
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class BookViewHolder constructor(
        itemView: View
    ):RecyclerView.ViewHolder(itemView) {
        private val bookImage: ImageView=itemView.findViewById(R.id.bookImage)
        private val bookTitle: TextView=itemView.findViewById(R.id.bookTitle)
        private val bookDescripiton:TextView=itemView.findViewById(R.id.bookDescription)

        fun bind(book:Book){
            Glide.with(itemView.context)
                .load(book.image)
                .into(bookImage)
            bookTitle.text=book.title
            bookDescripiton.text=book.description
        }


    }
}

