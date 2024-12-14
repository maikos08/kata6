package software.ulpgc.kata6.arquitecture.control.commands;

import software.ulpgc.kata6.arquitecture.control.Command;
import software.ulpgc.kata6.arquitecture.model.Calendar;

import java.time.LocalDate;
import java.util.Iterator;

public class WorkingDaysCommand implements Command {
    private final Input input;
    private final Output output;

    public WorkingDaysCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        output.workingDays(countWorkingDays());
    }

    private int countWorkingDays() {
        int days = 0;
        LocalDate current = input.start();
        Iterator<LocalDate> from  = new Calendar().iteratorFrom(input.start());
        while (current.isBefore(input.end())) {
            days++;
            current = from.next();
        }
        return days;
    }


    public interface Input {
        LocalDate start();
        LocalDate end();
    }

    public interface Output {
        void workingDays(int result);
    }
}
