object MatchingBrackets {
  def isPaired(brackets: String): Boolean = {
    val valid_chars = List('(',')','[',']','{','}')
    brackets.filter(valid_chars.contains).toCharArray.foldLeft(List.empty[Char]) { (acc, curr) =>
      if(List('(','[','{').contains(curr)) {
        curr :: acc
      }else{
        if(acc.isEmpty){
          curr :: acc
        }else{
          curr match {
            case ')' => if(acc.head == '(') acc.drop(1) else curr :: acc
            case '}' => if(acc.head == '{') acc.drop(1) else curr :: acc
            case ']' => if(acc.head == '[') acc.drop(1) else curr :: acc
            case _ => acc
          }
        }
      }
    }.isEmpty
  }
}

