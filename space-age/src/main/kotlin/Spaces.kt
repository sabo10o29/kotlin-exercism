import java.math.BigDecimal
import java.math.RoundingMode

enum class Planet(val orbitalPeriodEarthYears : Double){
    EARTH(1.0),
    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132);

    val EARTH_ORBITAL_PERIOD_SECONDS = 31557600

    fun earthYearsOld(pastTime: Long): Double{
        var v = BigDecimal.valueOf(pastTime/(orbitalPeriodEarthYears*EARTH_ORBITAL_PERIOD_SECONDS))
        return v.setScale(2, RoundingMode.HALF_UP).toDouble()
    }

}

class SpaceAge(val pastTime: Long){

    constructor(pastTime: Int): this(pastTime.toLong())

    fun onEarth(): Double{
        return Planet.EARTH.earthYearsOld(pastTime = pastTime)
    }

    fun onMercury(): Double{
        return Planet.MERCURY.earthYearsOld(pastTime = pastTime)
    }

    fun onVenus(): Double{
        return Planet.VENUS.earthYearsOld(pastTime = pastTime)
    }

    fun onMars(): Double{
        return Planet.MARS.earthYearsOld(pastTime = pastTime)
    }

    fun onJupiter(): Double{
        return Planet.JUPITER.earthYearsOld(pastTime = pastTime)
    }

    fun onSaturn(): Double{
        return Planet.SATURN.earthYearsOld(pastTime = pastTime)
    }

    fun onUranus(): Double{
        return Planet.URANUS.earthYearsOld(pastTime = pastTime)
    }

    fun onNeptune(): Double{
        return Planet.NEPTUNE.earthYearsOld(pastTime = pastTime)
    }

}