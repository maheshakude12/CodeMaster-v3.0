package com.codemaster.solution

import java.io.{File, PrintWriter}

import scala.io.Source

object Solution {

  def getLuckyNumber(a: Int): Int = {
    0
  }

  def main(args: Array[String]): Unit = {

    val input = Source.fromResource("Problem2_input.txt").getLines()
    val output = new PrintWriter(new File("output.txt"))
    var count = 0
    input.drop(1).foreach(x => {
      count = count + 1
      output.write(s"Request-$count: ${
        getLuckyNumber(x.toInt)
      }\n")
    }
    )
  }
}