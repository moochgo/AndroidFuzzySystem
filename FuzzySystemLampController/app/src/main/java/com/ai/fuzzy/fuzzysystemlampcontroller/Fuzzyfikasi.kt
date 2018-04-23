package com.ai.fuzzy.fuzzysystemlampcontroller

open class Fuzzyfikasi protected constructor() {
    var outGelap: Double = 0.toDouble()
        protected set
    var outRemang: Double = 0.toDouble()
        protected set
    var outAgakTerang: Double = 0.toDouble()
        protected set
    var outTerang: Double = 0.toDouble()
        protected set
    var outSangatTerang: Double = 0.toDouble()
        protected set
    var inGelap: Double = 0.toDouble()
        protected set
    var inAgakGelap: Double = 0.toDouble()
        protected set
    var inRemang: Double = 0.toDouble()
        protected set
    var inNormal: Double = 0.toDouble()
        protected set
    var inTerang: Double = 0.toDouble()
        protected set

    fun setFuzzyfikasi(indoor: Double, outdoor: Double) {
        //Fuzzyfikasi outdoor gelap
        if (outdoor == 0.0)
            outGelap = 1.0
        else if (outdoor > 0 && outdoor < 64)
            outGelap = (64 - outdoor) / 64
        else
            outGelap = 0.0

        //fuzzyfikasi outdoor remang-remang
        if (outdoor > 0 && outdoor < 64)
            outRemang = (outdoor - 0) / 64
        else if (outdoor >= 64 && outdoor <= 80)
            outRemang = 1.0
        else if (outdoor > 80 && outdoor < 100)
            outRemang = (100 - outdoor) / 20
        else
            outRemang = 0.0

        //fuzzyfikasi outdoor  Agak Terang
        if (outdoor > 80 && outdoor < 100)
            outAgakTerang = (outdoor - 80) / 20
        else if (outdoor >= 100 && outdoor <= 160)
            outAgakTerang = 1.0
        else if (outdoor > 160 && outdoor < 240)
            outAgakTerang = (240 - outdoor) / (240 - 160)
        else
            outAgakTerang = 0.0

        //fuzzyfikasi outdoor Terang
        if (outdoor > 160 && outdoor < 240)
            outTerang = (outdoor - 160) / (240 - 160)
        else if (outdoor >= 240 && outdoor <= 260)
            outTerang = 1.0
        else if (outdoor > 260 && outdoor < 280)
            outTerang = (280 - outdoor) / (280 - 260)
        else
            outTerang = 0.0

        //fuzzyfikasi outdoor Sangat Terang
        if (outdoor > 260 && outdoor < 280)
            outSangatTerang = (outdoor - 260) / (280 - 260)
        else if (outdoor >= 280)
            outSangatTerang = 1.0
        else
            outSangatTerang = 0.0

        //Fuzzyfikasi indoor gelap
        if (indoor == 0.0)
            inGelap = 1.0
        else if (indoor > 0 && indoor < 10)
            inGelap = (10 - indoor) / 10
        else
            inGelap = 0.0

        //fuzzyfikasi indoor agak gelap
        if (indoor > 0 && indoor < 10)
            inAgakGelap = (indoor - 0) / 10
        else if (indoor >= 10 && indoor <= 20)
            inAgakGelap = 1.0
        else if (indoor > 20 && indoor < 30)
            inAgakGelap = (30 - indoor) / 10
        else
            inAgakGelap = 0.0

        //fuzzyfikasi indoor Remang Remang
        if (indoor > 20 && indoor < 30)
            inRemang = (indoor - 20) / 10
        else if (indoor >= 30 && indoor <= 80)
            inRemang = 1.0
        else if (indoor > 80 && indoor < 100)
            inRemang = (100 - indoor) / 20
        else
            inRemang = 0.0

        //fuzzyfikasi indoor Normal
        if (indoor > 80 && indoor < 100)
            inNormal = (indoor - 80) / 20
        else if (indoor >= 100 && indoor <= 150)
            inNormal = 1.0
        else if (indoor > 150 && indoor < 180)
            inNormal = (180 - indoor) / 30
        else
            inNormal = 0.0

        //fuzzyfikasi indoor Terang
        if (indoor > 150 && indoor < 180)
            inTerang = (indoor - 150) / 30
        else if (indoor >= 180)
            inTerang = 1.0
        else
            inTerang = 0.0
    }
}
