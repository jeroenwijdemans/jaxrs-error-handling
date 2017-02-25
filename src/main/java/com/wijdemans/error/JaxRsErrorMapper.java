package com.wijdemans.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JaxRsErrorMapper implements ExceptionMapper<RuntimeException> {

    private static final Logger logger = LoggerFactory.getLogger(JaxRsErrorMapper.class);

    @Override
    public Response toResponse(RuntimeException exception) {
        logger.debug("Caught exception of type [{}] - mapping it to user.", exception.getClass());
        Errors e = new Errors(new Error(exception));

        return Response.status(mapStatus(exception))
                .entity(e.asJson())
                .encoding(MediaType.APPLICATION_JSON)
                .build();
    }

    public int mapStatus(RuntimeException exception) {
        if (exception instanceof IllegalStateException) {
            return 500;
        } else if (exception instanceof IllegalArgumentException) {
            return 400;
        } else if (exception instanceof NotFoundException) {
            return 404;
        }
        return 500;
    }

}
