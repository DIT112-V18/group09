package com.group9.dora

import android.util.Log

class Measure {

    companion object {

        var measurements: ArrayList<RoomCoordinate> = ArrayList()
        var distanceTraveled = 0f

        fun addDistance(dist: Float){
            distanceTraveled = dist
        }

        fun clearDistance(){
            distanceTraveled = 0f
        }

        fun verifyDistance(message: String){
            if(message.startsWith("#")){
                if(message.replace("#","").toFloatOrNull() != null){
                    addDistance(message.replace("#","").toFloat())
                }
            }
        }

        fun addCoordinate(coordinate: RoomCoordinate){
            measurements.add(coordinate)
        }

        fun clearCoordinates(){
            measurements.clear()
        }

        fun verifyCoordinate(message: String){
            val splittedString = message.split(",")

            if(splittedString.size == 2){
                if(splittedString[0].toFloatOrNull() != null && splittedString[1].toFloatOrNull() != null && (splittedString[0].toFloat() != 0f && splittedString[1].toFloat() != 0f)){
                    Log.d("COORDINATES", "ADDED COORDINATES SUCCESSFULLY: (${splittedString[0]},${splittedString[1]})")
                    addCoordinate(RoomCoordinate(splittedString[0].toFloat(), splittedString[1].toFloat()))
                }
            }
        }

    }

}