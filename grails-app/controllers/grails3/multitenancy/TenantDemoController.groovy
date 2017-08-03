package grails3.multitenancy

class TenantDemoController {

    def tenantDemoService

    def index() {
        [tenant: tenantDemoService.tenant]
    }
}
