package com.gtm.tictoctoe.viewmodels

import java.util.*

class Utils {


    companion object {
        var playerImpressions: HashMap<String, String> = HashMap<String, String>()

        /**
         * creates the impression of the player with empty tracks.
         */
        fun createOrReset() {

            playerImpressions.put("01", "")
            playerImpressions.put("02", "")
            playerImpressions.put("03", "")
            playerImpressions.put("11", "")
            playerImpressions.put("12", "")
            playerImpressions.put("13", "")
            playerImpressions.put("21", "")
            playerImpressions.put("22", "")
            playerImpressions.put("23", "")
        }
    }
}