
package br.edu.ifpb.pos.docker.web.producers;

import br.edu.ifpb.pos.docker.shared.interfaces.AlbumService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class AlbumServiceProducer {
    
    private static final String RESOURCE = "java:global/pos-docker-core/AlbumServiceImpl!br.edu.ifpb.pos.docker.shared.interfaces.AlbumService";
    
    @Dependent
    @Produces
    @Default
    private AlbumService getAlbumService() {
        return new ServiceLocator().lookup(RESOURCE, AlbumService.class);
    }
}
