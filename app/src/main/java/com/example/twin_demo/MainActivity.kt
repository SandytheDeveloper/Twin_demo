package com.example.twin_demo

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.BounceInterpolator
import android.view.animation.LayoutAnimationController
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv=findViewById<TextView>(R.id.tv)
        var btn=findViewById<Button>(R.id.btn)
        var tv2=findViewById<TextView>(R.id.tv2)
        var btn2=findViewById<Button>(R.id.btn2)
        var tv3=findViewById<TextView>(R.id.tv3)
        var btn3=findViewById<Button>(R.id.btn3)





        btn.setOnClickListener {
            var from = 1.0f
            var to = 0.0f

            if(tv.visibility== View.INVISIBLE){
                from=to
                to=1.0f
            }

            var an = AlphaAnimation(from, to)
            an.duration=5000
            tv.startAnimation(an)

        }

        btn2.setOnClickListener {
            var lay=findViewById<ViewGroup>(R.id.layout)
            var an=AlphaAnimation(0.0f,1.0f)
            an.duration=5000
            var cnt = LayoutAnimationController(an,0f)
            lay.layoutAnimation=cnt
            if (tv2!=null){
                lay.removeView(tv2)
            }
        }

        btn3.setOnClickListener {
            var p = Paint()

            var mt=p.measureText(tv3.text.toString())

            var an=TranslateAnimation(0f,-mt,0.0f,0.0f)
            an.duration=5000
            an.setInterpolator ( BounceInterpolator() )
            tv3.startAnimation(an)
        }



    }
}