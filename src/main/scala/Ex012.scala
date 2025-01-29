package com.robot2

import scala.collection.mutable
import scala.util.Random

object randomName {
  private var counter = 0

  private lazy val allNames: mutable.ArrayBuffer[String] = {
    val names = (for {
      x <- 'A' to 'Z'
      y <- 'A' to 'Z'
      z <- 0 to 999
    } yield f"$x$y$z%03d").to(mutable.ArrayBuffer)

    Random.shuffle(names)
  }

  def nextName(): String = {
    if(counter < allNames.length) {
      counter+= 1
      allNames(counter-1)
    } else {
      counter = 0
      allNames(counter)
    }
  }

  }

class Robot {
  private var robotName = ""
  reset()

  def name = robotName
  def reset() = robotName = randomName.nextName()
}