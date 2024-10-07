package kr.ac.kumoh.ce.s20240000.s24w04carddealer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kr.ac.kumoh.ce.s20240000.s24w04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Log.i("Lifecycle!!!", "onCreate")

        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        main= ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnDeal.setOnClickListener {
            val c = IntArray(5)
            val res = IntArray(5)

            //for (i in 0..4)
            //for (i in 0 until 5)
            //for (i in 0 until c.size)
            for (i in c.indices) {
                c[i] = Random.nextInt(52)

                Log.i("Test", "${c[i]} : " +
                        "${getCardName(c[i])}")

                res[i] = resources.getIdentifier(
                    getCardName(c[i]),
                    "drawable",
                    packageName
                )
            }

            main.imgCard1.setImageResource(res[0])
            main.imgCard2.setImageResource(res[1])
            main.imgCard3.setImageResource(res[2])
            main.imgCard4.setImageResource(res[3])
            main.imgCard5.setImageResource(res[4])
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.i("Lifecycle!!!", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.i("Lifecycle!!!", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i("Lifecycle!!!", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i("Lifecycle!!!", "onStop")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.i("Lifecycle!!!", "onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i("Lifecycle!!!", "onDestroy")
//    }
}