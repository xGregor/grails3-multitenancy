package grails3.mutitenancy

import grails.gorm.transactions.Transactional
import grails3.multitenancy.Tenant


class TenantDemoService {

    @Transactional
    Tenant getTenant() {
        Tenant.withNewSession {
            Tenant.first()
        }
    }
}
