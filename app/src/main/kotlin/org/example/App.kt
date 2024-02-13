/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.example

import jetbrains.buildServer.controllers.BaseController
import jetbrains.buildServer.web.openapi.PluginDescriptor
import jetbrains.buildServer.web.openapi.WebControllerManager
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class App : BaseController {

    private val myDescriptor : PluginDescriptor

    constructor (manager: WebControllerManager, descriptor: PluginDescriptor) {
        manager.registerController("/demoPlugin.html", this)
        myDescriptor = descriptor
    }
    
    override fun doHandle(request: HttpServletRequest, response: HttpServletResponse) : ModelAndView {
        return ModelAndView(myDescriptor.getPluginResourcesPath("Hello.jsp"));
    }
}