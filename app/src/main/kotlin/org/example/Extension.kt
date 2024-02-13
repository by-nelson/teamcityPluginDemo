package org.example

import jetbrains.buildServer.web.openapi.healthStatus.*
import jetbrains.buildServer.web.openapi.PluginDescriptor
import jetbrains.buildServer.web.openapi.PagePlaces
import jetbrains.buildServer.web.openapi.PlaceId

import javax.servlet.http.HttpServletRequest;

class Extension : HealthStatusItemPageExtension {

    constructor(pagePlaces : PagePlaces, descriptor: PluginDescriptor ) : super("DemoExtension", pagePlaces) {
        setPluginName("DemoPlugin")
        setPlaceId(PlaceId.HEALTH_STATUS_ITEM)

        setIncludeUrl(descriptor.getPluginResourcesPath("Hello.jsp"))

        register()
    }

    public override fun isAvailable(request: HttpServletRequest) : Boolean {
        return true 
    }

    public override fun fillModel(model : MutableMap<String, Any>, request: HttpServletRequest) : Unit {
        model.put("text", getStatusItem(request).getIdentity() + " has a severity equal to " + getStatusItem(request).getSeverity().getDisplayName())
    }
}
