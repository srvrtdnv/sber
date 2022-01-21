package ru.sarvartdinov.sber.api;

import org.springframework.stereotype.Controller;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

@Controller
public class GroupsApiController implements GroupsApi {

    private final GroupsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public GroupsApiController(GroupsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public GroupsApiDelegate getDelegate() {
        return delegate;
    }
}
