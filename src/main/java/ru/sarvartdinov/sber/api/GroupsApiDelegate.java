package ru.sarvartdinov.sber.api;

import ru.sarvartdinov.sber.api.model.Group;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link GroupsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

public interface GroupsApiDelegate {

    Logger log = LoggerFactory.getLogger(GroupsApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see GroupsApi#getGroups
     */
    default ResponseEntity<List<Group>> getGroups(List<String> groupIds) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"deactivatingDate\" : \"2000-01-23\",  \"userEmails\" : [ \"userEmails\", \"userEmails\" ],  \"lastUpdatingDate\" : \"2000-01-23\",  \"id\" : \"id\",  \"isActive\" : true,  \"creationDate\" : \"2000-01-23\"}, {  \"deactivatingDate\" : \"2000-01-23\",  \"userEmails\" : [ \"userEmails\", \"userEmails\" ],  \"lastUpdatingDate\" : \"2000-01-23\",  \"id\" : \"id\",  \"isActive\" : true,  \"creationDate\" : \"2000-01-23\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default GroupsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
