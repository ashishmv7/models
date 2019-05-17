package com.nividapps.wingsdomain

import com.iteration3.Smile._
import com.iteration3.smile._

class WingsDomainLifeCycle extends com.nividapps.wingsdomain.WingsDomainLifeCycleTrait {

  // def onStart():Unit= {} and def onStop():Unit = {}


     override def onServerStart(): Unit = {
        startAllCommandQueues()
     }

     override def onServerStop():Unit = {
        stopAllCommandQueues()
     }


}
