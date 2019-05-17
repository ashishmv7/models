package com.nividapps.wingsquery

import com.iteration3.Smile._
import com.iteration3.smile._

class WingsQueryLifeCycle extends com.nividapps.wingsquery.WingsQueryLifeCycleTrait {

  // def onStart():Unit= {} and def onStop():Unit = {}


     override def onServerStart(): Unit = {
        startAllProjections()
     }

     override def onServerStop():Unit = {
        stopAllProjections()
     }


}
