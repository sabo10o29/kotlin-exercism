import java.nio.ByteBuffer
import Signal.*

val MAX_SIGNAL_SIZE = 31
val REVERSE_SIGNAL = 16

enum class Signal(val code: Int) {

  WINK            (0b1),
  DOUBLE_BLINK    (0b10),
  CLOSE_YOUR_EYES (0b100),
  JUMP            (0b1000);

  fun containsSignal(inputSignal: Int):Boolean{
    return inputSignal and code == code
  }

}

object HandshakeCalculator{

  fun calculateHandshake(signal: Int): List<Signal>{
    if(signal>MAX_SIGNAL_SIZE) return emptyList()

    var result = mutableListOf<Signal>()
    for(v in Signal.values()){
      if(v.containsSignal(signal))result.add(v)
    }
    return if(signal and REVERSE_SIGNAL == REVERSE_SIGNAL) result.reversed() else result
  }

}
