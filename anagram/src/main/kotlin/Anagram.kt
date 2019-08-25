class Anagram(str: String){

    val lowStr = str.toLowerCase()

    fun match(list: List<String>): Set<String>{

        if(list.isEmpty()) return emptySet()

        var strList = lowStr.toList().sorted()
        var resultSet = HashSet<String>()
        for(tmp in list){
            val lowTemp = tmp.toLowerCase()
            if(lowStr.equals(lowTemp)) continue
            if(strList.equals(lowTemp.toList().sorted())) resultSet.add(tmp)
        }

        return if(resultSet.isEmpty()) emptySet() else resultSet
    }

}