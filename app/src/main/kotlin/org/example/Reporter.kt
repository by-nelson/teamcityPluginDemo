package org.example

import jetbrains.buildServer.serverSide.healthStatus.*

class Reporter : HealthStatusReport {

    private val dummyCategory : ItemCategory

    constructor() : super() {
        dummyCategory   = ItemCategory("DummyCategoryId", "DummyCategoryName", ItemSeverity.WARN, "This is a dummy category description", "to solve remove the plugin :)")
    }

        
    public override fun report(scope : HealthStatusScope, resultConsumer : HealthStatusItemConsumer) : Unit {

        val DummyStatusItem = HealthStatusItem("DummyStatusItem", dummyCategory, emptyMap<String,Any>())

        resultConsumer.consumeGlobal(DummyStatusItem)
    }

    public override fun getType() : String {
        return "DummyReporter"
    }

    public override fun getDisplayName() : String {
        return "DemoFinderDisplayName"
    }

    public override fun getCategories() : List<ItemCategory> {

        val categories = listOf(dummyCategory)
        return categories
    }

    public override fun canReportItemsFor(scope: HealthStatusScope) : Boolean {
        return true
    }
}
