package grails3.multitenancy

import grails.gorm.MultiTenant

class Tenant implements MultiTenant<Tenant> {

    String tenantId

    static constraints = {
    }
}
