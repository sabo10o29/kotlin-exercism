fun transcribeToRna(dna: String): String =

        when {
            "G".equals(dna) -> "C"
            "C".equals(dna) -> "G"
            "T".equals(dna) -> "A"
            "A".equals(dna) -> "U"
            dna.length > 1  ->
                transcribeToRna(dna[0].toString()) + transcribeToRna(dna.subSequence(1, dna.length).toString())
            else -> throw IllegalArgumentException("Unknown DNA strand.")
        }

