package com.example.recycleview

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.databinding.ItemLayoutBinding


class MainActivity : AppCompatActivity(), onCarItemClickedListener {

    private lateinit var binding: ActivityMainBinding
    private val items = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
        init()

    }

    private fun init() {
        animatedBackGround()

        binding.recycleView.layoutManager = GridLayoutManager(this, 1)
        binding.recycleView.adapter = RecycleViewAdapter(items, this)
    }

    private fun setData() {
        items.add(ItemModel("https://images.iconfigurators.app/images/gallery/Untitled-52_7148.jpg", "Lexus IS200t", "Turbocharged", "2.0 liter", "241 hp"))
        items.add(ItemModel("https://hips.hearstapps.com/roa.h-cdn.co/assets/17/16/1492608867-screen-shot-2017-04-19-at-92837-am-2.png", "Hyndai Genesis Coupe", "Turbocharged", "2.0 liter", "210 hp"))
        items.add(ItemModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-infiniti-q60-mmp-1-1604609169.jpg", "Infiniti Q60", "Not Turbocharged", "3.0 liter", "300 hp"))
        items.add(ItemModel("https://upload.wikimedia.org/wikipedia/commons/7/76/Nissan_370Z_Nismo_%28MSP15%29.JPG", "Nissan 370z", "Not Turbocharged", "3.7 liter", "332 hp"))
        // mapatiet tu vcdebi :DD
        items.add(ItemModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUFfzSXDmZ1u7pUxJQxKoBjwufFRINsIVW9A&usqp=CAU", "Mercedes C300", "Turbocharged", "2.0 liter", "245 hp"))
        items.add(ItemModel("https://cdnb.artstation.com/p/assets/images/images/016/421/649/large/william-silva-lexus-lc-500-2018-1600-23.jpg?1552093172", "Lexus LFA", "Not Turbocharged", "4.8 liter", "563 hp"))
        items.add(ItemModel("https://www.motortrend.com/uploads/sites/5/2019/10/2020-Hyundai-Sonata-Limited-prototype-front-side-view-motion.jpg", "Hyundai Sonata", "Hybrid", "2.5 liter", "192 hp"))
        items.add(ItemModel("https://www.automotiveaddicts.com/wp-content/uploads/2011/11/Toyota86_35.jpeg", "Toyota GT-86", "Not TurboCharged", "2.0 liter", "205 hp"))
        items.add(ItemModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2020-porsche-taycan-123-1569266409.jpg?crop=0.643xw:0.724xh;0.111xw,0.233xh&resize=640:*", "Porsche Taycan Turbo S", "Electric", "2 El.Engine", "616 hp"))
        items.add(ItemModel("https://cdn.motor1.com/images/mgl/7kVKp/s1/2020-bmw-m8-gran-coupe-competition.jpg", "BMW M8", "Twin-Turbo", "4.4 liter", "617 hp"))
        items.add(ItemModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7lV7gcJsDo86wMHhJ2GiJ1rkO_u6MBh27Lg&usqp=CAU", "Nissan R34", "Twin-Turbo", "2.6 liter", "276 hp"))
        items.add(ItemModel("https://www.diyany.net/wp-content/uploads/2019/12/horsepowered-car-min.jpg", "Kachka", "HorseCharged", "0 liter", "1 hp"))
    }

    private fun animatedBackGround() {

        val animationDrawable = binding.rootLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(10)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    override fun onItemClick(model: ItemModel, position: Int) {

        Toast.makeText(this, "${model.title} Moved to wish list, to buy press purchase button", Toast.LENGTH_SHORT).show()
        binding.purchaseButton.setOnClickListener {
            Toast.makeText(this, "congrats you bought ${model.title}", Toast.LENGTH_SHORT).show()
        }
    }

}