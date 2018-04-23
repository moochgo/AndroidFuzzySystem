package com.ai.fuzzy.fuzzysystemlampcontroller

open class Inferensi protected constructor() : Fuzzyfikasi() {
    internal var lampuTerang = DoubleArray(7)
    internal var lampuNormal = DoubleArray(8)
    internal var lampuRedup = DoubleArray(6)
    internal var lampuPadam = DoubleArray(4)
    var maxPadam = 0.0
        internal set
    var maxRedup = 0.0
        internal set
    var maxNormal = 0.0
        internal set
    var maxTerang = 0.0
        internal set

    fun getInferensi() {

        //RULE BASE KEADAAN TERANG
        if (inGelap != 0.0 && outGelap != 0.0)
            lampuTerang[0] = min(inGelap, outGelap)
        else
            lampuTerang[0] = 0.0
        if (inGelap != 0.0 && outRemang != 0.0)
            lampuTerang[1] = min(inGelap, outRemang)
        else
            lampuTerang[1] = 0.0
        if (inGelap != 0.0 && outAgakTerang != 0.0)
            lampuTerang[2] = min(inGelap, outAgakTerang)
        else
            lampuTerang[2] = 0.0
        if (inAgakGelap != 0.0 && outGelap != 0.0)
            lampuTerang[3] = min(inAgakGelap, outGelap)
        else
            lampuTerang[3] = 0.0
        if (inAgakGelap != 0.0 && outRemang != 0.0)
            lampuTerang[4] = min(inAgakGelap, outRemang)
        else
            lampuTerang[4] = 0.0
        if (inAgakGelap != 0.0 && outAgakTerang != 0.0)
            lampuTerang[5] = min(inAgakGelap, outAgakTerang)
        else
            lampuTerang[5] = 0.0
        if (inRemang != 0.0 && outGelap != 0.0)
            lampuTerang[6] = min(inRemang, outGelap)
        else
            lampuTerang[6] = 0.0
        for (i in 0..6) {
            if (maxTerang < lampuTerang[i])
                maxTerang = lampuTerang[i]
        }

        //RULE BASE KEADAAN NORMAL
        if (inGelap != 0.0 && outTerang != 0.0)
            lampuNormal[0] = min(inGelap, outTerang)
        else
            lampuNormal[0] = 0.0
        if (inAgakGelap != 0.0 && outTerang != 0.0)
            lampuNormal[1] = min(inAgakGelap, outTerang)
        else
            lampuNormal[1] = 0.0
        if (inNormal != 0.0 && outGelap != 0.0)
            lampuNormal[2] = min(inNormal, outGelap)
        else
            lampuNormal[2] = 0.0
        if (inRemang != 0.0 && outRemang != 0.0)
            lampuNormal[3] = min(inRemang, outRemang)
        else
            lampuNormal[3] = 0.0
        if (inNormal != 0.0 && outRemang != 0.0)
            lampuNormal[4] = min(inNormal, outRemang)
        else
            lampuNormal[4] = 0.0
        if (inTerang != 0.0 && outGelap != 0.0)
            lampuNormal[5] = min(inTerang, outGelap)
        else
            lampuNormal[5] = 0.0
        if (inTerang != 0.0 && outRemang != 0.0)
            lampuNormal[6] = min(inTerang, outRemang)
        else
            lampuNormal[6] = 0.0
        if (inRemang != 0.0 && outAgakTerang != 0.0)
            lampuNormal[7] = min(inRemang, outAgakTerang)
        else
            lampuNormal[7] = 0.0
        for (i in 0..7) {
            if (maxNormal < lampuNormal[i])
                maxNormal = lampuNormal[i]
        }

        //RULE BASE KEADAAN REDUP
        if (inGelap != 0.0 && outSangatTerang != 0.0)
            lampuRedup[0] = min(inGelap, outSangatTerang)
        else
            lampuRedup[0] = 0.0
        if (inAgakGelap != 0.0 && outSangatTerang != 0.0)
            lampuRedup[1] = min(inAgakGelap, outSangatTerang)
        else
            lampuRedup[1] = 0.0
        if (inRemang != 0.0 && outTerang != 0.0)
            lampuRedup[2] = min(inRemang, outTerang)
        else
            lampuRedup[2] = 0.0
        if (inNormal != 0.0 && outAgakTerang != 0.0)
            lampuRedup[3] = min(inNormal, outAgakTerang)
        else
            lampuRedup[3] = 0.0
        if (inNormal != 0.0 && outTerang != 0.0)
            lampuRedup[4] = min(inNormal, outTerang)
        else
            lampuRedup[4] = 0.0
        if (inTerang != 0.0 && outAgakTerang != 0.0)
            lampuRedup[5] = min(inTerang, outAgakTerang)
        else
            lampuRedup[5] = 0.0
        for (i in 0..5) {
            if (maxRedup < lampuRedup[i])
                maxRedup = lampuRedup[i]
        }

        //RULE BASE KEADAAN PADAM
        if (inRemang != 0.0 && outSangatTerang != 0.0)
            lampuPadam[0] = min(inRemang, outSangatTerang)
        else
            lampuPadam[0] = 0.0
        if (inNormal != 0.0 && outSangatTerang != 0.0)
            lampuPadam[1] = min(inNormal, outSangatTerang)
        else
            lampuPadam[1] = 0.0
        if (inTerang != 0.0 && outSangatTerang != 0.0)
            lampuPadam[2] = min(inTerang, outSangatTerang)
        else
            lampuPadam[2] = 0.0
        if (inTerang != 0.0 && outTerang != 0.0)
            lampuPadam[3] = min(inTerang, outTerang)
        else
            lampuPadam[3] = 0.0
        for (i in 0..3) {
            if (maxPadam < lampuPadam[i])
                maxPadam = lampuPadam[i]
        }
    }

    private fun min(`in`: Double, out: Double): Double {
        val hasil: Double
        if (`in` > out) {
            hasil = out
        } else
            hasil = `in`
        return hasil
    }
}
