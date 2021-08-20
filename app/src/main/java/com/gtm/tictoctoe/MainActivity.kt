package com.gtm.tictoctoe

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.gtm.tictoctoe.databinding.ActivityMainBinding
import com.gtm.tictoctoe.viewmodels.GameViewmodel
import com.gtm.tictoctoe.viewmodels.Utils

class MainActivity : AppCompatActivity() {


    lateinit var viewmodel: GameViewmodel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this).get(GameViewmodel::class.java)


        Utils.createOrReset()

        binding.tvReset.setOnClickListener {


            resetTheGame()
        }
        binding.zeroOne.setOnClickListener {

            updateUI("01", binding.zeroOne)
            viewmodel.checkTheWinner("01")

        }
        binding.zeroTwo.setOnClickListener {

            updateUI("02", binding.zeroTwo)

        }
        binding.zeroThree.setOnClickListener {
            updateUI("03", binding.zeroThree)
        }
        binding.oneOne.setOnClickListener {
            updateUI("11", binding.oneOne)
        }
        binding.oneTwo.setOnClickListener {
            updateUI("12", binding.oneTwo)
        }
        binding.oneThree.setOnClickListener {
            updateUI("13", binding.oneThree)
        }
        binding.twoOne.setOnClickListener {
            updateUI("21", binding.twoOne)
        }
        binding.twoTwo.setOnClickListener {
            updateUI("22", binding.twoTwo)
        }
        binding.twoThree.setOnClickListener {
            updateUI("23", binding.twoThree)
        }


    }


    /**
     * resets tracked clicks and UI
     */
    private fun resetTheGame() {

        Utils.createOrReset()

        binding.zeroOne.setImageDrawable(null)
        binding.zeroTwo.setImageDrawable(null)
        binding.zeroThree.setImageDrawable(null)
        binding.oneOne.setImageDrawable(null)
        binding.oneTwo.setImageDrawable(null)
        binding.oneThree.setImageDrawable(null)
        binding.twoOne.setImageDrawable(null)
        binding.twoThree.setImageDrawable(null)
        binding.twoTwo.setImageDrawable(null)
    }


    /**
     * updates the UI based on the position user clicked.
     */
    private fun updateUI(s: String, view: ImageView) {


        if (Utils.playerImpressions.get(s).equals("", false)) {

            viewmodel.doTaps()
            var _player: String = viewmodel.getWhichPlayer()
            drawPlayerTap(view, _player)

            Utils.playerImpressions.put(s, _player)
        } else {
            Log.d("One", "onCreate: Alaready Drwan")
        }
    }


    fun drawPlayerTap(view: ImageView, _player: String) {


        if (_player.contentEquals("P1")) {
            view.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_player_1
                )
            )
        } else {
            view.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_player_2
                )
            )
        }

    }
}