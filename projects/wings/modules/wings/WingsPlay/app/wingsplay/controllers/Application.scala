package wingsplay.controllers

import play.api._
import play.api.mvc._
import javax.inject.{Inject, Singleton}

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("Play module WingsPlay is ready.")
  }

}
