import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.javadsl.Behaviors
import akka.persistence.typed.PersistenceId
import akka.persistence.typed.scaladsl.EventSourcedBehavior

import java.util.{Date, UUID}

object Main extends App {

  case class Greet(whom: String)

  sealed trait Command

  case class invoice(recipient: String, date: Date, amoount: Double) extends Command
  sealed trait Event

  final case class State()

  object persistent {
    def apply(): Behavior[Command] = EventSourcedBehavior[Command, Event, State](
      persistenceId = PersistenceId.ofUniqueId(UUID.randomUUID().toString),
      emptyState = State(),
      commandHandler = (state, cmd) => throw new NotImplementedError("Not implemennted"),
      eventHandler = (state, evt) => throw new NotImplementedError("not implementned")
    )

  }

  object initor {
    def apply(): Behavior[String] = Behaviors.receiveMessage[String] {
      case "hello" => {
        println("Jerusalem")
        Behaviors.same
      }
      case _ => {
        println("Nothihng Short")
        Behaviors.same
      }

    }
  }

  val init = ActorSystem(initor(), "init")
  init tell ("hello")
  init ! ("banger")
  init.terminate()

}
