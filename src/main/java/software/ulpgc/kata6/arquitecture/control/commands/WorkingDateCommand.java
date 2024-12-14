package software.ulpgc.kata6.arquitecture.control.commands;

import software.ulpgc.kata6.arquitecture.control.Command;
import software.ulpgc.kata6.arquitecture.model.Calendar;

import java.time.LocalDate;
import java.util.Iterator;

public class WorkingDateCommand implements Command {
    private final Input input;
    private final Output output;

    public WorkingDateCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        output.workingDate(nextWorkingDate());
    }

    private LocalDate nextWorkingDate() {
        LocalDate result = null;
        Iterator<LocalDate> from = new Calendar().iteratorFrom(input.start());
        for (int i = 0; i < input.workingDays(); i++) {
            result = from.next();
        }
        return result;
    }

    public interface Input {
        LocalDate start();
        int workingDays();
    }

    public interface Output {
        void workingDate(LocalDate result);
    }
}
