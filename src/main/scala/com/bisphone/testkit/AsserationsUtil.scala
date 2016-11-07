package com.bisphone.testkit

import org.scalatest.Assertions

/**
  * @author Reza Samei <reza.samei.g@gmail.com>
  */
trait AsserationsUtil extends Assertions {

   def unexp[T](value: T): Unit = {
      fail(s"Unexpected Value: ${value}")
   }

   def unexp[T](value: T, cause: Throwable): Unit = {
      fail(s"Unexpected Value: ${value}", cause)
   }

}

