package com.bisphone.testkit

import scala.concurrent.{ExecutionContext, Future}
import scala.collection.mutable
import scala.reflect.ClassTag

/**
  * @author Reza Samei <reza.samei.g@gmail.com>
  */
trait Registery { self =>

   import ExecutionContext.Implicits.global

   private sealed trait Holder[T] {
      type valueType = T
      def get(registery: Registery): T
   }

   private class SimpleHolder[T](fn: Registery => T ) {
      def get(registery: Registery): T = fn(registery)
   }

   private class Singleton[T](fn: Registery => T) {
      private var value: Option[T] = None
      def get(registery: Registery) = {
         if (value.isDefined) synchronized {
            if (value.isDefined) synchronized {
               value = Some(fn(registery))
            }
         }
         value.get
      }
   }

   private val holder = mutable.HashMap.empty[(ClassTag[_],String), Holder[_]]

   def single[T](name: String)(factory: Registery => T)(
      implicit tag: ClassTag[T]
   ) = synchronized {
      holder((tag, name)) = new Singleton(factory).asInstanceOf[Holder[T]]
   }

   def set[T](name: String)(factory: Registery => T)(
      implicit tag: ClassTag[T]
   ) = synchronized {
      holder((tag, name)) = new SimpleHolder(factory).asInstanceOf[Holder[T]]
   }

   def get[T](name: String)(implicit tag: ClassTag[T]) = holder((tag, name)).get(self)

}
