package wings

import com.google.inject.AbstractModule

class WingsBinder extends AbstractModule {

def configure () {
bind (classOf[com.iteration3.smile.kplay.action.AuthSpi] ).to (classOf[AuthSpiCode] );
bind(classOf[com.iteration3.smile.kplay.action.AccessLogSpi]).to(classOf[AccessLogSpiCode]);
}
}

