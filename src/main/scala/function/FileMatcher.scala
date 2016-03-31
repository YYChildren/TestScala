package function

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles
  def filesEnding(query: String) = {
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file
  }
  
  def filesContaining(query: String) = {
    for (file <- filesHere; if file.getName.contains(query))
      yield file
  }

  def filesRegex(query: String) = {
    for (file <- filesHere; if file.getName.matches(query))
      yield file
  }

  def filesMatching2(query: String,
    matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }
  
  def filesEnding2(query:String) ={
    filesMatching2(query,_.endsWith(_))
  }
   
  def filesContaining2(query:String)={
   filesMatching2(query,_.contains(_))
  }
   
   def filesRegex2(query:String) = {
     filesMatching2(query,_.matches(_))  
   }
   
   
   
   def filesMatching3(
    matcher: (String) => Boolean) = {
    for(file <- filesHere; if matcher(file.getName))
      yield file
   }

   def filesEnding3(query:String) ={
     filesMatching3(_.endsWith(query))
   }
   
   def filesContaining3(query:String)={
     filesMatching3(_.contains(query))
   }
   
  def filesRegex3(query:String) = {
     filesMatching3(_.matches(query))
  }
}