package com.codemaster.solution

import java.io.{File, PrintWriter}

import scala.annotation.tailrec
import scala.io.Source

object Solution {

  @tailrec
  def getLuckyNumber(num: Long): Long = {
    val listOfDigits = num.toString.split("").toSeq
    if (listOfDigits.equals(listOfDigits.sorted)) {
      num
    } else {
      getLuckyNumber(num - 1)
    }
  }

  def main(args: Array[String]): Unit = {

    val input = Source.fromResource("Problem2_input.txt").getLines()
    val output = new PrintWriter(new File("output.txt"))
    var count = 0
    input.drop(1).foreach(x => {
      count = count + 1
      output.write(s"Request-$count: ${getLuckyNumber(x.toLong)}\n")
    }
    )
    output.close()
  }
}