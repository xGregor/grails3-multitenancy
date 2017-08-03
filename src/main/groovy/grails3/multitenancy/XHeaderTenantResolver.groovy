package grails3.multitenancy

import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

import javax.servlet.http.HttpServletRequest

class XHeaderTenantResolver implements TenantResolver {

    static final String TENANT_ID_HEADER = "X-Tenant-Name"

    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if (requestAttributes instanceof ServletWebRequest) {
            HttpServletRequest httpServletRequest = ((ServletWebRequest) requestAttributes).getRequest()
            def tenant = httpServletRequest.getHeader(TENANT_ID_HEADER)
            if (tenant)
                return tenant
        }
        throw new TenantNotFoundException("Tenant could not be resolved outside a web request")
    }
}
