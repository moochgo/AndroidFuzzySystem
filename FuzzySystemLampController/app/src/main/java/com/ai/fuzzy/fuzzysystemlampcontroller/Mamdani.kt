package com.ai.fuzzy.fuzzysystemlampcontroller

open class Mamdani protected constructor() : Inferensi() {

    protected var samplePadam = 1
    protected var sampleRedup = 10
    protected var sampleNormal = 35
    protected var sampleTerang = 20
    protected var sumSamplePadam = 0
    protected var sumSampleRedup = 0
    protected var sumSampleNormal = 0
    protected var sumSampleTerang = 0

    fun setCentroidMethod() {
        for (i in 10..20) {
            sumSampleRedup += i
        }
        for (i in 40..75) {
            sumSampleNormal += i
        }
        for (i in 80..100) {
            sumSampleTerang += i
        }
    }

    fun hasil(): Double {
        val hasil = (sumSamplePadam * maxPadam + sumSampleRedup * maxRedup + sumSampleNormal * maxNormal + sumSampleTerang * maxTerang) / (samplePadam * maxPadam + sampleRedup * maxRedup + sampleNormal * maxNormal + sampleTerang * maxTerang)
        return hasil

    }
}
