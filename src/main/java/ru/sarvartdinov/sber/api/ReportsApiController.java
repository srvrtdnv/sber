package ru.sarvartdinov.sber.api;

import org.springframework.stereotype.Controller;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

@Controller
public class ReportsApiController implements ReportsApi {

    private final ReportsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public ReportsApiController(ReportsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public ReportsApiDelegate getDelegate() {
        return delegate;
    }
}
