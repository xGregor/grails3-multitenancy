package grails3.multitenancy

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.gorm.multitenancy.Tenants

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)

        //Should be in Bootstraps, but it causes an exception
        //Multitenancy seams not initialized in Bootstrap
        Tenants.withId("tenant1") {
            new Tenant(tenantId: "tenant1").save()
        }
        Tenants.withId("tenant2") {
            new Tenant(tenantId: "tenant2").save()
        }

    }
}