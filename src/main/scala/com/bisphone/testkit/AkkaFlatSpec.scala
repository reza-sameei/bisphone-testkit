package com.bisphone.testkit

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import com.typesafe.config.Config
import org.scalatest._
import org.scalatest.matchers._

/**
  * @author Reza Samei <reza.samei.g@gmail.com>
  */
class AkkaFlatSpec(actorsys: ActorSystem)
  extends TestKit(actorsys)
  with ImplicitSender
  with FlatSpecLike
  with Matchers
  with BeforeAndAfterAll {

  def this(name: String, config: Config) = this(ActorSystem(name, config))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

}
