package software.ulpgc.kata6.app.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.arquitecture.control.commands.WorkingDateCommand;

import java.io.IOException;
import java.time.LocalDate;

public class WorkingDateRequestAdapter {

    public WorkingDateCommand.Input inputFor(HttpServletRequest request ) {
        return  new WorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.getParameter("start"));
            }

            @Override
            public int workingDays() {
                return Integer.parseInt(request.getParameter("days"));
            }
        };

    }

    public WorkingDateCommand.Output outputFor(HttpServletResponse response) {
        return result -> {
            try {
                response.getWriter().write(result.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
