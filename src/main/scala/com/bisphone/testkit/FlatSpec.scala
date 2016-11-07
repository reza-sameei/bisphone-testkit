package com.bisphone.testkit

import org.scalatest.{FlatSpec => ScalaTestFlatSpec, _}

/**
  * @author Reza Samei <reza.samei.g@gmail.com>
  */
trait FlatSpec
   extends ScalaTestFlatSpec
      with Matchers
      with BeforeAndAfter
      with AsserationsUtil