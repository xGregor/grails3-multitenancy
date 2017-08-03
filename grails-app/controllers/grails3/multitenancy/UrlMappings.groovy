package grails3.multitenancy

import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "tenantDemo", action: "index")
        "500"(view: '/error')
        "500"(view: '/tenantNotFound', exception: TenantNotFoundException)
        "404"(view: '/notFound')
    }
}
