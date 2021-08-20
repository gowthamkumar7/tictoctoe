package com.gtm.tictoctoe.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewmodel : ViewModel() {

    companion object {
        var TAG = GameViewmodel::class.java.name


    }


    var counter: Int = 0


    fun doTapOnce() {

    }


    fun doTaps() {

        counter++;

        if (counter % 2 == 0) {
            Log.d(TAG, "onCreate: Player 2 clicked")
        } else {
            Log.d(TAG, "onCreate: Player 1 clicked")
        }
    }

    fun getWhichPlayer(): String {

        if (counter % 2 == 0) {
            return "P2"
        } else {
            return "P1"
        }
    }

    fun checkTheWinner(s: String) {

        var winner: String = ""

        var charArray = s.toCharArray()


        var tempOne=3
        var tempTwo=3
        var f:Int = charArray[0] as Int;
        var t:Int = charArray[1] as Int;

        var map = Utils.playerImpressions





    }
}