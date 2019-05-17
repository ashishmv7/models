package wings.controllers

import play.api.mvc._
import javax.inject.{Inject, Singleton}


@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("Application wings is ready.")
  }

  def swaggerPlayModules = Action {

    val options = play.api.libs.json.Json.toJson(
      com.iteration3.smile.SmileModule.playModuleNodes.flatMap {
        psm => val visibleList = psm.conf.getStringList("swagger.visible")
          psm.metadata.swaggerNameList.filter(name => if(visibleList.isEmpty) true else visibleList.get.contains(name)).map  {
            sn =>  s"""{ "id" : "/${psm.metadata.routeFragment}/${sn.toLowerCase}", "value" : "$sn (${psm.name})"}"""
          }
      }.mkString("[", ",", "]")
    )
    Ok(options)
  }



}
