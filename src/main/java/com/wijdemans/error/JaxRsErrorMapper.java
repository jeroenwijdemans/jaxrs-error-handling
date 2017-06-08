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

    private Response NOT_FOUND = Response.status(404)
            .entity(Errors.create(Error.create(Error.UNKNOWN, "Page not found.")).asJson())
            .encoding(MediaType.APPLICATION_JSON)
            .build();

    @Override
    public Response toResponse(RuntimeException exception) {
        logger.debug("Caught exception of type [{}] - mapping it to user.", exception.getClass());

        if (exception instanceof UserException) {
            return Response.status(400)
                    .entity(((UserException) exception).getErrors().asJson())
                    .encoding(MediaType.APPLICATION_JSON)
                    .build();
        } else if (exception instanceof NotFoundException) {
            return NOT_FOUND;
        }
        else if (exception instanceof ErrorsException) {
            return Response.status(500)
                    .entity(((ErrorsException) exception).getErrors().asJson())
                    .encoding(MediaType.APPLICATION_JSON)
                    .build();
        }

        return Response.status(500)
                .entity(Errors.create(Error.create(exception)).asJson())
                .encoding(MediaType.APPLICATION_JSON)
                .build();
    }


}
