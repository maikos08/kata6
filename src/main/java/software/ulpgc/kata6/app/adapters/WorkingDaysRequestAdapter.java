package software.ulpgc.kata6.app.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.arquitecture.control.commands.WorkingDaysCommand;

import java.io.IOException;
import java.time.LocalDate;

public class WorkingDaysRequestAdapter {

    public WorkingDaysCommand.Input inputFor(HttpServletRequest request) {
        return new WorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.getParameter("start"));
            }

            @Override
            public LocalDate end() {
                return LocalDate.parse(request.getParameter("end"));
            }
        };
    }

    public WorkingDaysCommand.Output outputFor(HttpServletResponse response) {
        return result -> {
            try {
                response.getWriter().println(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
