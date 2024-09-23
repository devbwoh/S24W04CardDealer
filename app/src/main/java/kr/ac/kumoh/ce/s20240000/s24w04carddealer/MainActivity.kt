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

    //@SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        main= ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnDeal.setOnClickListener {
            //main.imgCard1.setImageResource(R.drawable.c_2_of_hearts)
            val c = Random.nextInt(52)
            Log.i("Card!!!!!!!!", "$c : ${getCardName(c)}")
            Log.i("Card!!!!!!!!", "${R.drawable.c_2_of_clubs}")
            Log.i("Card!!!!!!!!", "${R.drawable.c_2_of_diamonds}")

            val res = resources.getIdentifier(
                getCardName(c),
                "drawable",
                packageName
            )

            main.imgCard1.setImageResource(res)
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
}