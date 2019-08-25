import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Gigasecond(localDateTime : LocalDateTime){

    constructor(localDate: LocalDate)
            : this(LocalDateTime.of(localDate, LocalTime.of(0,0)))

    var date = localDateTime.plusSeconds(1000000000)

}