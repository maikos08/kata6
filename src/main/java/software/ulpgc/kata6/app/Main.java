package software.ulpgc.kata6.app;

import software.ulpgc.kata6.app.adapters.WorkingDateRequestAdapter;
import software.ulpgc.kata6.app.adapters.WorkingDaysRequestAdapter;
import software.ulpgc.kata6.arquitecture.control.CommandFactory;
import software.ulpgc.kata6.arquitecture.control.commands.WorkingDateCommand;
import software.ulpgc.kata6.arquitecture.control.commands.WorkingDaysCommand;

public class Main {

    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();
        factory.register("working-date", workingDateBuilder());
        factory.register("working-days", workingDaysBuilder());
        new WorkingDateService(8080, factory).start();

    }

    private static CommandFactory.Builder workingDateBuilder() {
        return (req, res) -> {
            var adapter = new WorkingDateRequestAdapter();
            return new WorkingDateCommand(adapter.inputFor(req), adapter.outputFor(res));
        };
    }

    private static CommandFactory.Builder workingDaysBuilder() {
        return (req, res) -> {
            var adapter = new WorkingDaysRequestAdapter();
            return new WorkingDaysCommand(adapter.inputFor(req), adapter.outputFor(res));
        };
    }
}
