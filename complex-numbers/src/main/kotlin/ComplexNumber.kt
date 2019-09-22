import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0){
    val abs = sqrt(real.pow(2) + imag.pow(2))
}

operator fun ComplexNumber.plus(other: ComplexNumber): ComplexNumber{
    return ComplexNumber(real + other.real, imag + other.imag)
}

operator fun ComplexNumber.minus(other: ComplexNumber): ComplexNumber{
    return ComplexNumber(real - other.real, imag - other.imag)
}

operator fun ComplexNumber.times(other: ComplexNumber): ComplexNumber{
    return ComplexNumber(real*other.real - imag * other.imag, real*other.imag + imag * other.real)
}

operator fun ComplexNumber.div(other: ComplexNumber): ComplexNumber{
    val denominator = other.real.pow(2) + other.imag.pow(2)
    val realNum = other.real * real + other.imag * imag
    val imgNum = other.real * imag - other.imag * real
    return ComplexNumber(realNum/denominator, imgNum/denominator)
}

fun ComplexNumber.conjugate(): ComplexNumber{
    return ComplexNumber(real, -imag)
}

fun exponential(v: ComplexNumber): ComplexNumber{
    return ComplexNumber(exp(v.real) * cos(v.imag), exp(v.real) * sin(v.imag))
}