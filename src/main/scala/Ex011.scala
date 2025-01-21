object SecretHandshake {

  def convertToBinary(input: Int) : String = {
    var result = ""
    var num = input
    while(num>0) {
      val div = num/2
      val mod = num%2

      result = result + mod.toString
      num = div
    }
    result.reverse
  }

  val actions = List("wink", "double blink", "close your eyes" ,"jump", "reverse")

  def commands(num: Int) :Array[String] = {
    val decodedActions = convertToBinary(num)
      .toCharArray
      .reverse
      .zipAll(actions,'0',"")
      .filter{ case (bin, _) => bin=='1'}
      .reverse
      .map{case (_, action) => action}

    if(decodedActions.isEmpty){
      Array.empty[String]
    }
    else if(decodedActions.head.eq("reverse")){
      decodedActions.drop(1)
    }else decodedActions.reverse
  }
}
