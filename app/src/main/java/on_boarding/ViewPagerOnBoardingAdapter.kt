package on_boarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.SliderBinding

class ViewPagerOnBoardingAdapter(val context : Context) : PagerAdapter() {
    var layoutInflater : LayoutInflater? = null


    //array of images , main phrases , support phrases
    val imgArray = arrayOf(
        R.drawable.main_boarding,
        R.drawable.award,
        R.drawable.shopping_cart
    )

    val mainPhrasesArray = arrayOf(
        "Bishkek Stroi",
        "Качество - залог успеха",
        "Приступим к покупкам!"
    )

    val supportPhrasesArray = arrayOf(
        "Лучший магазин со строительными материалами",
        "Мы обеспечим вас любыми необходимыми высококачественными строительными материалами по демократическим ценам",
        "Но перед этим небольшая регистрация :)"
    )
    override fun getCount(): Int {
        return mainPhrasesArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider, container, false)
        val img = view.findViewById<ImageView>(R.id.main_logo)
        val mainPhrase = view.findViewById<TextView>(R.id.main_phrase)
        val supportPhrase = view.findViewById<TextView>(R.id.support_phrase)
        img.setImageResource(imgArray[position])
        mainPhrase.text= mainPhrasesArray[position]
        supportPhrase.text = supportPhrasesArray[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}