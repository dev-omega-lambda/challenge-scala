package readcsv

import scala.io.Source

@main def sortCsv(): Unit = {
  val lines = Source
    .fromFile("src/main/scala/sites.csv")
    .getLines()
    .toList

  val linesMap = lines
    .map(_.split(","))
    .map(v => (v(0).toInt, v(1)))
    .toMap

  val sortedLines = linesMap
    .toSeq
    .sortWith(_._1 < _._1)

  sortedLines.foreach(println)
}
